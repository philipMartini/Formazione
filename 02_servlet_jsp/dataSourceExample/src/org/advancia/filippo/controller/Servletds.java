package org.advancia.filippo.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.advancia.filippo.model.Elemento;

/**
 * Servlet implementation class Servletds
 */
@WebServlet("/Servletds")
public class Servletds extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servletds() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		try 
		{
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/test");
			
			Connection conn = dataSource.getConnection();
			System.out.println("Connessione stabilita");
			
			ArrayList<Elemento> persone = new ArrayList<Elemento>();
			
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("Select * from prova");
			
			while (rs.next())
			{
				Elemento el = new Elemento();
				el.setNome(rs.getString("nome"));
				el.setCognome(rs.getString("cognome"));
				el.setEta(rs.getString("eta"));
				persone.add(el);
			}
			
			request.setAttribute("pers", persone);
			
			getServletContext().getRequestDispatcher("/stampa.jsp").forward(request, response);
			
			rs.close(); 
			stmt.close();
			conn.close();
			
		} 
		catch (NamingException | SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
