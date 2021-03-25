package org.advancia.filippo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	  
	
	public void init(ServletConfig config)
	   throws ServletException {
	    super.init(config);
	    try {
	      // Load the driver
	      Class.forName("com.mysql.jdbc.Driver").newInstance(  );
	    }
	    catch (ClassNotFoundException e) {
	      throw new UnavailableException(
	       "Login init() ClassNotFoundException: " + e.getMessage(  ));
	    }
	catch (IllegalAccessException e) { throw new UnavailableException(
	       "Login init() IllegalAccessException: " + e.getMessage(  ));
	    }
	    catch (InstantiationException e) {
	      throw new UnavailableException(
	"Login init() InstantiationException: " + e.getMessage( )); }
	}
	
	
	
	  public void doGet(
	   HttpServletRequest request, HttpServletResponse response)
	   throws IOException, ServletException {
	response.setContentType("text/html"); PrintWriter out = response.getWriter( ); out.println("<html>"); out.println("<head>"); out.println("<title>Login</title>"); out.println("</head>"); out.println("<body>");
	    HttpSession session = request.getSession(  );
	    Connection connection =
	(Connection)session.getAttribute("connection"); if (connection == null) {
	      String userName = request.getParameter("username");
	 
	      String password = request.getParameter("password");
	      if (userName == null || password == null) {
	// Prompt the user for her username and password 
	 out.println("<form method=\"get\" action=\"login\">"); 
	 out.println("Please specify the following to log in:<p>"); 
	 out.println("Username: <input type=\"text\" " + "name=\"username\" size=\"30\"><p>"); 
	 out.println("Password: <input type=\"password\" " + "name=\"password\" size=\"30\"><p>"); 
	 out.println("<input type=\"submit\" value=\"login\">"); 
	 out.println("</form>");
	} else {
	        // Create the connection
	        try {
	          connection = DriverManager.getConnection(
	        		  "jdbc:mysql://localhost:3306/test", userName, password);
	        }
	        catch (SQLException e) {
	          out.println("Login doGet() " + e.getMessage(  ));
	        }
	        if (connection != null) {
	          // Store the connection
	          session.setAttribute("connection", connection);
	          response.sendRedirect("login");
	          return;
	} }
	} else {
	      String logout = request.getParameter("logout");
	      if (logout == null) {
	        // Test the connection
	        Statement statement = null;
	        ResultSet resultSet = null;
	        String    userName  = null;
	        try {
	          statement = connection.createStatement(  );
	          resultSet = statement.executeQuery(
	           "select * from prova");
	          if (resultSet.next(  ))
	            userName = resultSet.getString(1);
	        }
	catch (SQLException e) {
	out.println("Login doGet() SQLException: " + e.getMessage( )
	+ "<p>"); }
	        finally {
	          if (resultSet != null)
	            try { resultSet.close(  ); } catch (SQLException ignore) { }
	          if (statement != null)
	try { statement.close( ); } catch (SQLException ignore) { } }
	        out.println("Hello " + userName + "!<p>");
	        out.println("Your session ID is " + session.getId(  ) + "<p>");
	        out.println("It was created on " +
	new java.util.Date(session.getCreationTime( )) + "<p>");
	out.println("It was last accessed on " +
	         new java.util.Date(session.getLastAccessedTime(  )) + "<p>");
	out.println("<form method=\"get\" action=\"login\">"); 
	out.println("<input type=\"submit\" name=\"logout\" " + "value=\"Logout\">");
	out.println("</form>");
	} else {
	// Close the connection and remove it from the session
	/********IL Problema fondamentale di questo metodo è che l'utente non fa il logout
	 * Esplicitamente la connessione rimane aperta e il compito grava quindi sul DBMS
	 * Che appena si rende conto che la connessione è inattiva la chiude
	 * è quindi necessario implementare una classe SessionConnection che implementa 
	 * HTTPSessionBindingListener che abbia il compito di chiudere
	 * In ogni caso la connessione***********/
	try { connection.close( ); } catch (SQLException ignore) { } session.removeAttribute("connection");
	out.println("You have been logged out.");
	} }
	    out.println("</body>");
	    out.println("</html>");
	  }
	  public void doPost(
	   HttpServletRequest request, HttpServletResponse response)
	   throws IOException, ServletException {
	    doGet(request, response);
	  }
	}
