package org.advancia.filippo.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CoffeeDataBean {
	
	private Connection connection;
	private Statement statement;
	private PreparedStatement prepStatement;
	//Questo serve per chiamare le stored procedures
	private CallableStatement storedProc;
	

	public CoffeeDataBean() {
		// TODO Auto-generated constructor stub
	}
	
	public CoffeeDataBean(Connection connection) throws Exception{
		this.connection = connection;
		this.statement =  this.connection.createStatement();
	}
	
	   // return an ArrayList of CoffeeBeans
	   public ArrayList< CoffeeBean > getCoffeesList() throws SQLException
	   {
	      ArrayList< CoffeeBean > coffeesList = new ArrayList< CoffeeBean >();
	      
	      //String query = "SELECT  COF_NAME, PRICE, TOTAL FROM COFFEES";
	      
	      this.prepStatement = this.connection.prepareCall("{call get_coffees_and_quantities()}");
	      this.prepStatement.execute();
	      
	      //ResultSet results = this.statement.executeQuery(query);
	      
	      ResultSet results = this.prepStatement.getResultSet();
	      
	      

	      // get row data
	      while ( results.next() ) 
	      {
	         CoffeeBean coffee = new CoffeeBean();

	         coffee.setCoffeeName(results.getString( 1 ));
	         coffee.setPrice(results.getDouble( 2 ));
	         coffee.setQuantity(results.getInt( 3 ) );
	         coffee.setSuppName(results.getString(4));

	         coffeesList.add( coffee ); 
	      } // end while

	      return coffeesList;
	   }
	   
	   
	   public List<SupplierBean> getSuppliers(){
		   List<SupplierBean> suppliers = new ArrayList<>();
		   String query = "SELECT  SUP_ID, SUP_NAME FROM SUPPLIERS";
		   try {
			this.statement = this.connection.createStatement();
			ResultSet results = this.statement.executeQuery(query);
			while(results.next()){
				SupplierBean supp = new SupplierBean();
				
				supp.setId(results.getInt(1));
				supp.setName(results.getString(2));
				suppliers.add(supp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		   return suppliers;
		   
	   }
	   
	   // insert a guest in guestbook database
	   public void addCoffee( CoffeeBean coffee, int supplier_id ) throws SQLException
	   {	
		  
	      
	      //String preparedQuery = "INSERT INTO COFFEES ( COF_NAME, PRICE, TOTAL) VALUES (?, ?, ?)";
	      System.out.println("Adding: " + coffee);
	      //this.prepStatement = this.connection.prepareStatement(preparedQuery);
	      //this.prepStatement.setString(1, coffee.getCoffeeName());
	      //this.prepStatement.setDouble(2, coffee.getPrice());
	      //this.prepStatement.setInt(3, coffee.getQuantity());
	      this.storedProc = this.connection.prepareCall("{call create_coffee(?, ?, ?, ?)}");
	      this.storedProc.setString(1, coffee.getCoffeeName());
	      this.storedProc.setDouble(2, coffee.getPrice());
	      this.storedProc.setInt(3, coffee.getQuantity());
	      this.storedProc.setInt(4, supplier_id);
	      System.out.println("STORED PROC  CALL: " + this.storedProc.toString());
	      this.storedProc.execute();
	      
	      
	      //System.out.println("Query: " + this.prepStatement.toString());
	      //this.prepStatement.executeUpdate();
	      
		   		
	   } 
	   
	   public void deleteCoffee(CoffeeBean coffee) throws Exception{
		   
		   String preparedQuery = "DELETE FROM COFFEES WHERE COF_NAME=?";
		   this.prepStatement = this.connection.prepareStatement(preparedQuery);
		   this.prepStatement.setString(1, coffee.getCoffeeName());
		   this.prepStatement.executeUpdate();
	   }
	   
	   //Overloading deleteCoffee => solo la Pkey è necessaria per cancellare un caffe
	   public void deleteCoffee(String coffeeName) throws Exception{
		   
		   String preparedQuery = "DELETE FROM COFFEES WHERE COF_NAME=?";
		   this.prepStatement = this.connection.prepareStatement(preparedQuery);
		   this.prepStatement.setString(1, coffeeName);
		   this.prepStatement.executeUpdate();
	   }
	   
	   public void updateCoffee(String oldCoffeeName, CoffeeBean coffee) throws Exception{
		   System.out.println("Update: " + coffee);
		   String updateNameAndPrice = "UPDATE COFFEES SET COF_NAME = ?, PRICE = ? WHERE COF_NAME = ?";
		   String updateQuantity = "UPDATE COF_INVENTORY SET QUAN = ? WHERE COF_NAME = ?";
		   try (PreparedStatement updateCoffee = this.connection.prepareStatement(updateNameAndPrice);
			         PreparedStatement updateCoffeeInventory = this.connection.prepareStatement(updateQuantity))
			    
			    {
			      this.connection.setAutoCommit(false);
			      	
			      	updateCoffee.setString(1, coffee.getCoffeeName());
			        updateCoffee.setDouble(2, coffee.getPrice());
			        updateCoffee.setString(3, oldCoffeeName);
			        System.out.println("UPDATING: "+ updateCoffee.toString());
			        updateCoffee.executeUpdate();

			        updateCoffeeInventory.setDouble(1, coffee.getQuantity());
			        updateCoffeeInventory.setString(2, oldCoffeeName);
			        System.out.println("UPDATING: " + updateCoffeeInventory.toString());
			        updateCoffeeInventory.executeUpdate();
			        this.connection.commit();
			        
			        
			        this.connection.setAutoCommit(true);
			    } catch (SQLException e) {
			      e.printStackTrace();
			    }
		   
		   /*this.prepStatement = this.connection.prepareStatement(preparedQuery);
		   this.prepStatement.setString(1, coffee.getCoffeeName());
		   this.prepStatement.setInt(2, 101);
		   this.prepStatement.setDouble(3, coffee.getPrice());
		   this.prepStatement.setInt(4, 0);
		   this.prepStatement.setInt(5, coffee.getQuantity());
		   this.prepStatement.setString(6, oldCoffeeName);
		   this.prepStatement.executeUpdate();*/
	   }
	   
	   
	   public Connection getConnection() { return this.connection; }
	   /*
	   protected void finalize(){
		   try{
			   this.statement.close();
			   this.connection.close();
			   
		   }catch(SQLException e){ e.printStackTrace();}
	   }
		*/
}
