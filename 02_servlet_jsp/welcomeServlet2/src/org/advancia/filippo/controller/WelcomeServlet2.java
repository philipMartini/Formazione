package org.advancia.filippo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeServlet2
 */
@WebServlet("/welcome2")
public class WelcomeServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recupero i parametri query dall'URL
		String name = request.getParameter("firstName");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		//Head del documento
		out.println("<head>");
		out.println("<title>A Simple Servlet Example</title>");
		out.println("</head>");
		
		//Body
		out.println("<body>");
		out.println("<h1>Hello " + name + " </h1>");
		out.println("<h1>Welcome To Servlets</h1>");
		out.println("</body>");
		
		out.println("</html>");
		out.close();
	}

}
