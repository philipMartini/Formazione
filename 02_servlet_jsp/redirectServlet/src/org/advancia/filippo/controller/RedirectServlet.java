package org.advancia.filippo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RedirectServlet
 */
@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String location = request.getParameter("page");
		
		if(location != null){
			if(location.equals("deitel"))
				response.sendRedirect("http://www.deitel.com");
			else
				response.sendRedirect("http://localhost:8080/welcomeServlet1/welcome1");
		}
		
		//Se non viene passato il parametro page viene eseguito questo
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		//Head del documento
		out.println("<head>");
		out.println("<title>A Simple Servlet Example</title>");
		out.println("</head>");
		
		//Body
		out.println("<body>");
		out.println("<h1>Wrong Page Requested!</h1>");
		out.println("<a href=\"/redirectServlet\">Click Here To Choose Again</a>");
		out.println("</body>");
		
		out.println("</html>");
		out.close();
		
	}

}
