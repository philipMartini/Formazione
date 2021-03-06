package org.advancia.filippo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.advancia.filippo.dataOperations.CacheConnection;


@WebServlet("/cachePool")
public class CachedConnectionServlet extends HttpServlet {

  public void doGet(
   HttpServletRequest request, HttpServletResponse response) 
   throws IOException, ServletException {

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Cached Connection Servlet</title>");
    out.println("</head>");
    out.println("<body>");

    // let's turn on verbose output
    CacheConnection.setVerbose(true);

    // now let's get a cached connection
    Connection connection = CacheConnection.checkOut();
  
    Statement  statement  = null;
    ResultSet  resultSet  = null;
    String     userName   = null;  
    try { 
      // test the connection
      statement = connection.createStatement();
      resultSet = statement.executeQuery(
       "SELECT USER();");
      if (resultSet.next())
       userName = resultSet.getString(1);
    }
    catch (SQLException e) {
      out.println("DedicatedConnection.doGet() SQLException: " + 
       e.getMessage() + "<p>");
    }
    finally {
      if (resultSet != null) 
        try { resultSet.close(); } catch (SQLException ignore) { }
      if (statement != null) 
        try { statement.close(); } catch (SQLException ignore) { }
    }

    // let's return the conection
    CacheConnection.checkIn(connection);

    out.println("Hello " + userName + "!<p>");
    out.println("You're using a cached connection!<p>");
    out.println("</body>");
    out.println("</html>");
  }

  public void doPost(
   HttpServletRequest request, HttpServletResponse response)
   throws IOException, ServletException {
    doGet(request, response);
  }
}
