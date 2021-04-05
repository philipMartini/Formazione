package org.advancia.filippo.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/*
 * Connessione al database utilizzando il pattern creazionale Singleton
 */

/**
 *
 * @author Andrea
 */
public class dbConnection {
    
    private static dbConnection connection;
    public Connection conn;
    
    private dbConnection() throws NamingException{
    	// Parametri per la connessione al db
    	String user = "student";
    	String pwd = "student";
    	String inst = "localhost";
    	String db = "test";
    	try {
    		// Load driver
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			// Connect to the local database
			 this.conn = (Connection) DriverManager.getConnection("jdbc:mysql://" + inst + "/" + db +"?user=" + user +"&password=" + pwd);
		} catch(SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
		}
    }

    public static Connection getConnection() throws NamingException {
        if (connection == null){
            connection = new dbConnection();
        }
        return connection.conn;
    }    
}
