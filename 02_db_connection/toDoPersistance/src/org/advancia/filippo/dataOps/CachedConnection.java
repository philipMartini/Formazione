package org.advancia.filippo.dataOps;

import java.sql.Connection;

public class CachedConnection {
	
	private Connection connection;
	private boolean inUse;

	public CachedConnection() {
		this.connection = null;
		this.inUse = false;
	}

	public CachedConnection(Connection connection, boolean inUse) {
		super();
		this.connection = connection;
		this.inUse = inUse;
	}
	
	public Connection getConnection() { 
	    return connection; 
	  }

	  public void setConnection(Connection conn) { 
	    this.connection = conn; 
	  }

	  public boolean getInUse() {
	    return inUse;
	  }

	  public boolean isInUse() {
	    return inUse;
	  }

	  public void setInUse(boolean inUse) {
	    this.inUse = inUse;
	  }

}
