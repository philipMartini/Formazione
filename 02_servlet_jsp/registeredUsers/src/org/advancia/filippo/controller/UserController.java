package org.advancia.filippo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.advancia.filippo.model.User;

/**
 * Servlet implementation class UserController
 */
@WebServlet(description = "A simple list of registered users", urlPatterns = { "/usersLista" })
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<User> users;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        this.users = new ArrayList<>();
        System.out.println("Calling Servlet Constructor");
        //this.getServletContext().setAttribute("usersList", this.users);
        //this.users.add(new User("pippo", "pippo", "pipp@pippo.com"));
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher;
		//Se viene passato un id utente
		if(!request.getParameter("id").equals("")){
			int indx = Integer.parseInt(request.getParameter("id"));
			//recuperalo dalla lista e passalo come attributo di request
			System.out.println( this.users.get(indx));
			request.setAttribute("user", this.users.get(indx));
			dispatcher = request.getServletContext().getRequestDispatcher("/views/userProfile.jsp");
			dispatcher.forward(request, response);
		}
		else{
		
			System.out.println("USERS:");
			for(User u : this.users)
				System.out.println(u);
			dispatcher = request.getServletContext().getRequestDispatcher("/views/users.jsp");
			request.getServletContext().setAttribute("usersList", this.users);
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("name");
		String userSurname = request.getParameter("surname");
		String userEmail = request.getParameter("email");
		
		
		if(!this.users.contains(new User(userName, userSurname, userEmail))){
			System.out.println("Adding User: " +  new User(userName, userSurname, userEmail));
			this.users.add(new User(userName, userSurname, userEmail));
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/views/users.jsp");
			//Passo la lista aggiornata
			request.getServletContext().setAttribute("usersList", this.users);
			dispatcher.forward(request, response);
		}else{
			response.sendRedirect("views/users.jsp");
		}
		
	}

}
