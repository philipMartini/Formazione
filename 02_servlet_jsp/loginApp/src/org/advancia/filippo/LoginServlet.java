package org.advancia.filippo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.advancia.filippo.dto.User;
import org.advancia.filippo.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Dalla richesta prendiamo i parametri della POST
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		//E li inoltriamo al buisness service
		LoginService loginService = new LoginService();
		boolean result = loginService.authenticate(userId, password);
		//Se il result è true redirect alla success page
		if(result){
			// Il model in questo caso il model è un java bean di tipo User
			User userDetails = loginService.getUserDetails(userId);
			System.out.println(userDetails);
			if(userDetails != null){
				//L'unico scope possibile per salvare user è session, infatti request non va bene
				//infatti sendredirect effettua un'altra richiesta quindi le informazioni andrebbero perse, application renderebbe le credenziali disponibili a tutti
				//gli utenti che usano la login page => session
				//Ma se non potessi per qualche ragione salvarlo nell'oggetto session?
				//Quindi come faccio a inoltrare la stessa richiesta ad una JSP o ad un'altra servlet
				//*****request.getSession().setAttribute("user", userDetails);********
				//*******SI USA IL REQUESTDISPATCHER*********** che di fatto non notifica al browser la redirection
				//Quindi al posto di settare l'attributo nella session posso farlo nella request
				request.setAttribute("user", userDetails);
				RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
				//Per mentenere la stessa richiesta di fatto la inoltriamo semplicemente  a success.jsp che otterrà la stessa coppia req/response
				dispatcher.forward(request, response);
				//ATTENZIONE Il metodo sendRedirect è mutuamente esclusivo rispetto ad esempio
				//Alla scrittura nello stream di out, ad esempio: non posso scrivere html nella response e poi
				//fare un send redirect
				//******response.sendRedirect("success.jsp");******
				return;
			}else{
				response.sendRedirect("login.jsp");
				return;
			}
			
			
		}else{
			//Se i result è false si redirect al login
			response.sendRedirect("login.jsp");
			return;
		}
		
		
		
	}

}
