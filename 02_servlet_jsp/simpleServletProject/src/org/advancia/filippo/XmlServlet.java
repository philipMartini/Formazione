package org.advancia.filippo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Questa servlet non ha annotazioni è stata configurata tramite web.xml
 * => più verboso, ma non devo cambiare il codice della classe e non devo compilare nuovamente
 * Quindi web.xml favorisce separazione fra codice e configurazione.
 * Ovviamente va fatto ripartire Tomcat se web.xml viene modificato*/
public class XmlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Prendi lo stream della response inserisci html e restituisci la responde al client
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<h1>Hello From XMLServlet GET Method! </h1>");
		out.println("</html>");
		out.close();
	}
}
