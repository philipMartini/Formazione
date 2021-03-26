package org.advancia.filippo.dataOperations;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.MissingResourceException;
import java.util.Properties;

public class Database {
  private static boolean verbose  = false;

  public static final Connection getConnection(String baseName) {
    Connection conn = null;
    String driver   = null;
    String url      = null;
    String username = null;
    String password = null;
    try {
      //ResourceBundle resb = ResourceBundle.getBundle(baseName);
    	ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    	System.out.println(classLoader.toString());
    	InputStream input = classLoader.getResourceAsStream("/database.properties");
    	Properties props = new Properties();
    	props.load(input);
    	driver = props.getProperty("driver");
    	url = props.getProperty("dburl");
    	username = props.getProperty("user");
    	password = props.getProperty("password");
    	
      /*driver              = resb.getString("database.driver");
      url                 = resb.getString("database.url");
      username            = resb.getString("database.username");
      password            = resb.getString("database.password");*/
    	
      Class.forName(driver);
    }
    catch(MissingResourceException e) {
      System.err.println("Missing Resource: " + e.getMessage());
      return conn;
    }
    catch(ClassNotFoundException e) {
      System.err.println("Class not found: " + e.getMessage());
      return conn;
    } catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    try {
      if (verbose) {
        System.out.println("baseName=" + baseName);
        System.out.println("driver=" + driver);
        System.out.println("url=" + url);
        System.out.println("username=" + username);
        System.out.println("password=" + password);
      }

      conn = DriverManager.getConnection(url, username, password);
    }
    catch(SQLException e) {
      System.err.println(e.getMessage());
      System.err.println("in Database.getConnection");
      System.err.println("on getConnection");
      conn = null;
    }
    finally {
      return conn;
    }
  }

  public static void setVerbose(boolean v) {
    verbose = v;
  }
}
