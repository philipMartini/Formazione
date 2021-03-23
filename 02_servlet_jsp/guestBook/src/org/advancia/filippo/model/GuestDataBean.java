package org.advancia.filippo.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GuestDataBean {

	private Connection connection;
	private Statement statement;
	private PreparedStatement prepStatement;

	   // construct TitlesBean object 
	   public GuestDataBean() throws Exception
	   {
		   Class.forName("com.mysql.jdbc.Driver");
		   this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/guestbook", 
				   "student" , "student");
		   this.statement =  this.connection.createStatement();
	   } // end GuestDataBean constructor

	   // return an ArrayList of GuestBeans
	   public ArrayList< GuestBean > getGuestList() throws SQLException
	   {
	      ArrayList< GuestBean > guestList = new ArrayList< GuestBean >();
	      
	      String query = "SELECT firstName, lastName, email FROM guests";
	      ResultSet results = this.statement.executeQuery(query);
	      
	      

	      // get row data
	      while ( results.next() ) 
	      {
	         GuestBean guest = new GuestBean();

	         guest.setFirstName( results.getString( 1 ) );
	         guest.setLastName( results.getString( 2 ) );
	         guest.setEmail( results.getString( 3 ) );

	         guestList.add( guest ); 
	      } // end while

	      return guestList;
	   } // end method getGuestList
	   
	   // insert a guest in guestbook database
	   public void addGuest( GuestBean guest ) throws SQLException
	   {	
		   //QUesta modalità è delirante proviamo con le prepared statements
	      /*String query = "INSERT INTO guests ( firstName, lastName, email) "+
	    		  	" VALUES ( '"+ guest.getFirstName() + "', '" + guest.getLastName() 
	    		  	+ "', '" + guest.getEmail() + "' );";*/
	      
	      String preparedQuery = "INSERT INTO guests ( firstName, lastName, email) VALUES (?, ?, ?)";
	      this.prepStatement = this.connection.prepareStatement(preparedQuery);
	      this.prepStatement.setString(1, guest.getFirstName());
	      this.prepStatement.setString(2, guest.getLastName());
	      this.prepStatement.setString(3, guest.getEmail());
	      
	      System.out.println("Query: " + this.prepStatement.toString());
	      this.prepStatement.executeUpdate();
	      //this.statement.executeUpdate(query);
		   		
	   } // end method addGuest
	   
	   
	   protected void finalize(){
		   try{
			   this.statement.close();
			   this.connection.close();
			   
		   }catch(SQLException e){ e.printStackTrace();}
	   }

}
