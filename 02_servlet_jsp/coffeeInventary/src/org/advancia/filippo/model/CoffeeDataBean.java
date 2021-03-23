package org.advancia.filippo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CoffeeDataBean {
	
	private Connection connection;
	private Statement statement;
	private PreparedStatement prepStatement;
	

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
	      
	      String query = "SELECT  COF_NAME, PRICE, TOTAL FROM COFFEES";
	      ResultSet results = this.statement.executeQuery(query);
	      
	      

	      // get row data
	      while ( results.next() ) 
	      {
	         CoffeeBean coffee = new CoffeeBean();

	         coffee.setCoffeeName(results.getString( 1 ));
	         coffee.setPrice(results.getDouble( 2 ));
	         coffee.setQuantity(results.getInt( 3 ) );

	         coffeesList.add( coffee ); 
	      } // end while

	      return coffeesList;
	   } // end method getGuestList
	   
	   // insert a guest in guestbook database
	   public void addCoffee( CoffeeBean coffee ) throws SQLException
	   {	
		   //QUesta modalità è delirante proviamo con le prepared statements
	      /*String query = "INSERT INTO guests ( firstName, lastName, email) "+
	    		  	" VALUES ( '"+ guest.getFirstName() + "', '" + guest.getLastName() 
	    		  	+ "', '" + guest.getEmail() + "' );";*/
	      
	      String preparedQuery = "INSERT INTO COFFEES ( COF_NAME, PRICE, TOTAL) VALUES (?, ?, ?)";
	      this.prepStatement = this.connection.prepareStatement(preparedQuery);
	      this.prepStatement.setString(1, coffee.getCoffeeName());
	      this.prepStatement.setDouble(2, coffee.getPrice());
	      this.prepStatement.setInt(3, coffee.getQuantity());
	      
	      System.out.println("Query: " + this.prepStatement.toString());
	      this.prepStatement.executeUpdate();
	      //this.statement.executeUpdate(query);
		   		
	   } // end method addGuest
	   
	   public void deleteCoffee(CoffeeBean coffee) throws Exception{
		   
		   String preparedQuery = "DELETE FROM COFFEES WHERE COF_NAME=?";
		   this.prepStatement = this.connection.prepareStatement(preparedQuery);
		   this.prepStatement.setString(1, coffee.getCoffeeName());
		   this.prepStatement.executeUpdate();
	   }
	   
	   
	   public void deleteCoffee(String coffeeName) throws Exception{
		   
		   String preparedQuery = "DELETE FROM COFFEES WHERE COF_NAME=?";
		   this.prepStatement = this.connection.prepareStatement(preparedQuery);
		   this.prepStatement.setString(1, coffeeName);
		   this.prepStatement.executeUpdate();
	   }
	   
	   
	   protected void finalize(){
		   try{
			   this.statement.close();
			   this.connection.close();
			   
		   }catch(SQLException e){ e.printStackTrace();}
	   }

}
