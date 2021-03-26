package org.advancia.filippo.dataOps;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

//Questa classe deve essere un singleton
public class MyConnectionsPool {
	
	 private static int     numberConnections = 0;
	 private static Vector<CachedConnection>  cachedConnections = new Vector<>();
	 private static MyConnectionsPool instance = null;
	 private static boolean verbose = true;
	 
	 //Creiamo in anticipo un pool di connessioni aperte
	 private MyConnectionsPool(){
		 for(int i = 0; i < 7; ++i){
		     cachedConnections.add(new CachedConnection(DatabaseConnector.getConnection(), false));
		     numberConnections++;
		 }
			
	 }
	 
	 public static MyConnectionsPool getInstance(){
		 if(instance == null)
			 instance = new MyConnectionsPool();
		 return instance;
	 }

	 synchronized public Connection getAFreeConnection() {
		    boolean          found  = false;
		    CachedConnection cached = null; 

		    if (verbose) {
		      System.out.println("There are " + 
		       Integer.toString(numberConnections) + 
		       " connections in the cache");
		      System.out.println("Searching for a connection not in use...");
		    }
		    for (int i=0;!found && i<numberConnections;i++) {
		      if (verbose) {
		        System.out.println("Vector entry " + Integer.toString(i));
		      }
		      cached = cachedConnections.get(i);
		      if (!cached.isInUse()) {
		        if (verbose) {
		          System.out.println("found cached entry " + 
		           Integer.toString(i));
		        }
		        found = true;
		      }
		    }
		    if (found) {
		      cached.setInUse(true);
		    }
		    else {
		      if (verbose) {
		        System.out.println("Cached entry not found ");
		        System.out.println("Allocating new entry for");
		      }
		      cached = new CachedConnection(DatabaseConnector.getConnection(), true);
		      cachedConnections.add(cached);
		      numberConnections++;
		    }

		    return cached.getConnection();
		  }
	 
	 
	 synchronized public void freeConnection(Connection c) {
		    boolean          found  = false;
		    boolean          closed = false;
		    CachedConnection cached = null; 
		    Connection       conn   = null;
		    int              i      = 0;

		    if (verbose) {
		      System.out.println("Searching for connection to set not in use...");
		    }
		    for (i=0;!found && i<numberConnections;i++) {
		      if (verbose) {
		        System.out.println("Vector entry " + Integer.toString(i));
		      }
		      cached = cachedConnections.get(i);
		      conn = cached.getConnection();
		      if (conn.equals(c)) {
		        if (verbose) {
		          System.out.println("found cached entry " + Integer.toString(i));
		        }
		        found = true; 
		      }
		    }
		    if (found) {
		      try { 
		        closed = conn.isClosed();
		      }
		      catch(SQLException ignore) {
		        closed = true;
		      }
		      if (!closed) 
		        cached.setInUse(false);
		      else {
		        cachedConnections.remove(i);    
		        numberConnections--;
		      }
		    }
		    else if (verbose) {
		      System.out.println("In use Connection not found!!!");
		    }
		  }


}
