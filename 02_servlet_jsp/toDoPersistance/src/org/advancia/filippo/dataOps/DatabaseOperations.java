package org.advancia.filippo.dataOps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.advancia.filippo.model.ToDoBean;

public class DatabaseOperations {
	
	public static List<ToDoBean> getToDos(){
		MyConnectionsPool pool = MyConnectionsPool.getInstance();
		Connection connection = pool.getAFreeConnection();
		
		String query = "SELECT * FROM todos";
		List<ToDoBean> toDos = null;
		
		try {
			Statement statement = connection.createStatement();
			statement.executeQuery("select sleep(30);");
			ResultSet results = statement.executeQuery(query);
			toDos = new ArrayList<>();
			int id;
			String title;
			String text;
			
			while(results.next()){
				id = results.getInt(1);
				title = results.getString(2);
				text = results.getString(3);
				toDos.add(new ToDoBean(id, title, text));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			pool.freeConnection(connection);
		}
		
		return toDos;
	}
	
	
	public static List<ToDoBean> getToDosNoSleep(){
		MyConnectionsPool pool = MyConnectionsPool.getInstance();
		Connection connection = pool.getAFreeConnection();
		
		String query = "SELECT * FROM todos";
		List<ToDoBean> toDos = null;
		
		try {
			Statement statement = connection.createStatement();
			statement.executeQuery("select sleep(15);");
			ResultSet results = statement.executeQuery(query);
			toDos = new ArrayList<>();
			int id;
			String title;
			String text;
			
			while(results.next()){
				id = results.getInt(1);
				title = results.getString(2);
				text = results.getString(3);
				toDos.add(new ToDoBean(id, title, text));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			pool.freeConnection(connection);
		}
		
		return toDos;
	}
	
	
	public static void addToDo(ToDoBean toDo){
		String preparedQuery = "INSERT INTO todos (title, text) VALUES (?, ?)";
		MyConnectionsPool pool = MyConnectionsPool.getInstance();
		Connection connection = pool.getAFreeConnection();
		
		try {
			PreparedStatement prepStatement = connection.prepareStatement(preparedQuery);
			prepStatement.setString(1, toDo.getTitle());
			prepStatement.setString(2, toDo.getText());
			prepStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			pool.freeConnection(connection);
		}
		
	}
	
	public static void deleteToDo(int id) {
		
		MyConnectionsPool pool = MyConnectionsPool.getInstance();
		Connection connection = pool.getAFreeConnection();
		String prepQuery = "DELETE FROM todos WHERE id=?;";
		try {
			PreparedStatement prep = connection.prepareStatement(prepQuery);
			prep.setInt(1, id);
			prep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			pool.freeConnection(connection);
		}
		
	}
	

}
