package org.advancia.filippo.dataOps;


import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DatabaseConnector {

	public static final Connection getConnection() {
		
		Context initContext = null;
		Context envContext = null;
		DataSource ds = null;
		Connection connection = null;
		try{
			initContext = new InitialContext();
	        envContext = (Context) initContext.lookup("java:comp/env");
	        ds = (DataSource) envContext.lookup("jdbc/dbToDo");
	        connection = ds.getConnection();
        }catch (NamingException ex) {
            System.err.println(ex);
        } catch (SQLException ex) {
            System.err.println(ex);
        }
		catch(Exception e){
			System.err.println(e);
		}
		finally{
			return connection;
		}
	  }

}
