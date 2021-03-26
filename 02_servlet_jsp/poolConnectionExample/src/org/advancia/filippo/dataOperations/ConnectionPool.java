package org.advancia.filippo.dataOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionPool {

	//La variabile che gestisce l'unica istanza di ConnectionPool
	private static ConnectionPool connectionPool = null;
	
	private Vector<Connection> freeConnections; // la coda di connessioni libere
	private String dbUrl; 						// il nome del database
	private String dbDriver; 					// il driver del database
	private String dbLogin;						// il login per il database
	private String dbPassword; 					// la password di accesso al database
	private Context context;
	private DataSource dataSource;
	
	// Costruttore della classe ConnectionPool
	private ConnectionPool() throws ConnectionPoolException {
		//Costruisce la coda delle connessioni libere
		freeConnections = new Vector<Connection>();
		//Open 7 free connections
		for(int i = 0; i < 7; ++i){
			try {
				loadParameters();
				this.freeConnections.add(dataSource.getConnection());
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Nuova connessione avviata correttamente.");
		}
			
		
	}
	
	/**
	 * Restituisce un pool di connessioni.
	 * @return un pool di connessioni
	 * @throws ConnectionPoolException
	 */
	public static synchronized ConnectionPool getConnectionPool() 
									throws ConnectionPoolException {
		
		if(connectionPool == null) {
			connectionPool = new ConnectionPool();
		}
		return connectionPool;
	}
	
	/**
	 * Restituisce una connessione libera prelevandola dalla coda freeConnection
	 * oppure, se non ci sono connessioni disponibili, creandone una nuova con
	 * una chiamata a newConnection.
	 * 
	 * @return una connessione libera o una nuova connessione
	 * @throws ConnectionPoolException
	 * @throws NamingException 
	 * @throws SQLException 
	 */
	public synchronized Connection getConnection() throws ConnectionPoolException, NamingException, SQLException {
		Connection con;
		if(freeConnections.size() > 0) {
			// Se la coda delle connessioni libere non � vuota
			// preleva il primo elemento e lo rimuove dalla coda
			con = freeConnections.firstElement();
			freeConnections.removeElementAt(0);
			
			try {
				// Verifica se la connessione non � pi� valida
				if (con.isClosed()) {
					// Richiama getConnection ricorsivamente
					con = getConnection();
				}
				
			} catch (SQLException e) {
				// se c'� un errore richiama GetConnection ricorsivamente
				con = getConnection();
			}
		} else {
			// se la coda delle connessioni libere � vuota crea una nuova connessione
			//con = newConnection();
			loadParameters();
			con = dataSource.getConnection();
			System.out.println("Nuova connessione avviata correttamente.");
		}
		
		return con;
	}
	
	/**
	 * Rilascia una connessione inserendola nella coda delle connessioni libere.
	 * @param con la connessione da rilasciare
	 */
	public synchronized void releaseConnection(Connection con) {
		freeConnections.add(con);
	}
	
	// Restituisce una nuova connessione
	private Connection newConnection() throws ConnectionPoolException {
		Connection con = null;
		
		try {
			// crea la connessione
			con = DriverManager.getConnection(dbUrl);
		} catch (SQLException e) {
			// in caso di errore solleva un'eccezione
			throw new ConnectionPoolException();
		}
		
		return con;
	}

	// Funzione privata che carica i parametri per l'accesso al database
	private void loadParameters() throws NamingException {
		// Url per un database locale
		//dbUrl = "jdbc:mysql://localhost:3306/test";
		// Driver per database mysql
		//dbDriver = "com.mysql.jdbc.Driver";
		// Login della base di dati
		//dbLogin = "username";
		// Password per l'accesso al database
		//dbPassword = "password";
		context = new InitialContext();
		dataSource = (DataSource) context.lookup("java:comp/env/jdbc/test");
		System.out.println("Connessione stabilita");
	}
	
	// Funzione privata che carica il driver per l'accesso al database.
	// In caso di errore durante il caricamento del driver solleva un'eccezione.
	private void loadDriver() throws ConnectionPoolException {
		try {
			Class.forName(
					dbDriver + "?user=" + dbLogin 
					+ "&password=" + dbPassword);
		} catch (Exception e) {
			throw new ConnectionPoolException();
		}
	}
}
