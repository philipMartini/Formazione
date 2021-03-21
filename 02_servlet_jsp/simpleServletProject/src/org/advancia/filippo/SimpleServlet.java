package org.advancia.filippo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SimpleServlet
 */
//Queste annotazioni nei web projects precendenti alla 3.0 erano inserite nel web.xml
@WebServlet(description = "A simple servlete example", urlPatterns = { "/SimpleServletPath" },
	//Questi vengono passati al metodo init(ServletConfig config).....Per recuperarli....
	initParams={@WebInitParam(name="defaultUser", value="John Doe")}

		)

public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Se ho intenzione di utilizzare dei parametri con il metodo GET 
		 * devo usare gli URL parameters ossia in questo caso: 
		 localhost:8080/simpleServletProject/SimpleServletPath?userName=Phil&password=MyPASS*/
		String userName = request.getParameter("username");
		String pass = request.getParameter("password");
		
		//HTTP è stateless, ma supponiamo di voler salvare delle informazioni che rigurdano l'utente
		//Per personalizzare la UX => in questo contesto entra in gioco lo scope di Session
		HttpSession session = request.getSession();
		
		
		//E se volessi salvare delle informazioni che siano di scope piu ampio di Session? => 
		//In questo caso lo scope di Context rende disponibili delle infomrmazioni disponibili 
		//tra più richieste => condiviso fra piu servlets e utenti => COntext Object
		ServletContext context = request.getServletContext();
		
		
		if(userName != null && !userName.equals("")){
			session.setAttribute("savedUserName", userName);
			context.setAttribute("savedUserName", userName);
			}
		
		
		//Setta il MIME
		response.setContentType("text/html");
		//Prendi lo stream della response inserisci html e restituisci la response al client
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<h1>Hello ");
		out.print("Request parameter: " + userName);
		out.print("<br>");
		out.println(" Session Parameter: " + (String) session.getAttribute("savedUserName"));
		out.print("<br>");
		out.println(" Context Parameter: " + (String) context.getAttribute("savedUserName"));
		out.print("<br>");
		out.print("Init Config Parameter:" + this.getServletConfig().getInitParameter("defaultUser"));//.....Devo Chiamare questoMetodo
		out.print("<br>");
		out.print("\tYour password is: " + pass + "\t");
		out.print("<br>");
		out.print(" From GET Method! </h1>");
		out.println("</html>");
		out.close();
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*In alternativa posso usare il metodo POST*/
		String userName = request.getParameter("userName");
		String fullName = request.getParameter("fullName");
		String prof = request.getParameter("prof");
		//il parametro location contiene piu valori in contemporanea => bisogna chiamare 
		String[] loc = request.getParameterValues("location");
		
		
		//Setta il MIME
		response.setContentType("text/html");
		//Prendi lo stream della response inserisci html e restituisci la response al client
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<h1>Hello ");
		out.print(userName + "\t" + fullName);
		out.print("\tYou are a : " + prof + " That lives " + String.join("\t", loc));
		out.print("\tFrom POST Method! </h1>");
		out.println("</html>");
		out.close();
	}

}
