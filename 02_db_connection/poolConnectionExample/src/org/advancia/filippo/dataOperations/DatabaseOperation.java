package org.advancia.filippo.dataOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;

import javax.naming.NamingException;

import org.advancia.filippo.model.Person;

import com.sun.istack.internal.logging.Logger;

/**
 * Classe utilizzata per descrivere le operazioni eseguibili sul DB.
 */
public class DatabaseOperation {
	private static Connection databaseConnection;
	static {
		//connessione al DB
		try {
			databaseConnection = ConnectionPool.getConnectionPool().getConnection();
		} catch (ConnectionPoolException e) {
			System.out.println("ConnectionPool non collabora");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Il database non collabora");
			e.printStackTrace();
		} catch (NamingException e) {
			System.out.println("Il datasource non collabora");
			e.printStackTrace();
		}
	}
	
	private static Connection getConn() throws SQLException {
		return databaseConnection;
	}
	
	/**
	 * Legge tutte le righe della tabella people.
	 * @return una lista di persone presenti nella tabella Person
	 */
	public static List<Person> readPeopleTable() {
		// lista dove si andranno a inserire le righe della tabella
		List<Person> people = new LinkedList<Person>();
		try {
			//creazione statement
			Statement stmt = getConn().createStatement();
			//stmt.executeQuery("select sleep(30);");
			ResultSet pRes = stmt.executeQuery("SELECT id, firstName, lastName, age FROM people");
			System.out.println("Risultati select su people:");
			// scorriamo la tabella e inseriamo i valori trovati nella list
			while(pRes.next()){
				int id = pRes.getInt("id");
				String firstName = pRes.getString("firstName");
				String lastName = pRes.getString("lastName");
				int age = pRes.getInt("age");
				people.add(new Person(id, firstName, lastName, age));
				System.out.println(id + " " + firstName + " " + lastName + " " + age);
			}
		} catch (SQLException e) {
			Logger.getLogger(DatabaseOperation.class.getName(), DatabaseOperation.class).log(Level.SEVERE, null, e);
		}
		return people;
	}

	public static void editPersonById(int id, Person p) {
		try {
			String preparedSql = "UPDATE people SET firstName=?, lastName=?, age=? WHERE id=?";
			PreparedStatement prepStmt = getConn().prepareStatement(preparedSql);
			prepStmt.setString(1, p.getFirstName());
			prepStmt.setString(2, p.getLastName());
			prepStmt.setInt(3, p.getAge());
			prepStmt.setInt(4, id);
			System.out.println("Executing statement " + prepStmt.toString());
			prepStmt.execute();
		} catch (SQLException e) {
			Logger.getLogger(DatabaseOperation.class.getName(), DatabaseOperation.class).log(Level.SEVERE, null, e);
		}
		
	}

	public static void addPerson(Person p) {
		try {
			String sql = "INSERT INTO people (id, firstName, lastName, age) VALUES (NULL, ?, ?, ?)";
			//si utilizza un preparedStatement nel quale la stringa rappresentante
			//lo statement utilizza dei ? al posto dei valori da 
			//inserire/cancellare/aggiornare
			PreparedStatement prepStmt = getConn().prepareStatement(sql);
			prepStmt.setString(1, p.getFirstName());
			prepStmt.setString(2, p.getLastName());
			prepStmt.setInt(3, p.getAge());
			System.out.println("Executing statement " + prepStmt.toString());
			prepStmt.execute();
		} catch (SQLException e) {
			Logger.getLogger(DatabaseOperation.class.getName(), DatabaseOperation.class).log(Level.SEVERE, null, e);
		}
	}

	/**
	 * Elimina una persona dalla tabella tramite ID.
	 * @param id l\'identificatore della persona da eliminare
	 */
	public static void deletePersonByID(int id) {
		try {
			String sql = "DELETE FROM people WHERE id=" + id;
			Statement stmt = getConn().createStatement();
			stmt.execute(sql);
		} catch (SQLException e) {
			Logger.getLogger(DatabaseOperation.class.getName(), DatabaseOperation.class).log(Level.SEVERE, null, e);
		}
	}

	/**
	 * Recupera una riga della tabella tramite uso di ID.
	 * @param id l'identificativo della persona desiderata nella tabella
	 * @return i dati relativi alla persona con l\'id indicato
	 * @throws IllegalArgumentException
	 */
	public static Person getPersonByID(int i) throws IllegalArgumentException {
		try {
			String sql = "SELECT id, firstName, lastName, age FROM people WHERE id = " + i;
			Statement stmt = getConn().createStatement();
			ResultSet pRes = stmt.executeQuery(sql);
			
			if (!pRes.next()) throw new IllegalArgumentException();
			
			int id = pRes.getInt("id");
			String firstName = pRes.getString("firstName");
			String lastName = pRes.getString("lastName");
			int age = pRes.getInt("age");
			
			return new Person(id, firstName, lastName, age);		
		} catch (SQLException e) {
			Logger.getLogger(DatabaseOperation.class.getName(), DatabaseOperation.class).log(Level.SEVERE, null, e);
		}
		return null;
	}
}
