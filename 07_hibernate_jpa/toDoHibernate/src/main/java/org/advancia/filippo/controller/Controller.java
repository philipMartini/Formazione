package org.advancia.filippo.controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.advancia.filippo.dataOperations.DatabaseOperations;
import org.advancia.filippo.model.ToDo;
import org.advancia.filippo.model.User;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/todos")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("user") != null) {
			User user = (User) request.getSession().getAttribute("user");
			Collection<ToDo> toDos = DatabaseOperations.getToDosForUser(user);
			request.setAttribute("toDos", toDos);
			request.getRequestDispatcher("views/todos.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("/toDoHibernate");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("signup") != null) {
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			User user = DatabaseOperations.userSignup(userName, password);
			if(user == null) {
				
				request.setAttribute("error", "User Is Already Registered!");
				request.getRequestDispatcher("views/signup.jsp").forward(request, response);
				
			}
			else {
				request.setAttribute("toDos", user.getToDos());
				//Salvo id utente nella sessione
				request.getSession().setAttribute("user", user);
				request.getRequestDispatcher("views/todos.jsp").forward(request, response);
			}
		}
		
		
		
		else if(request.getParameter("login") != null) {
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			User user = DatabaseOperations.userLogin(userName, password);
			if(user != null) {
				request.setAttribute("toDos", user.getToDos());
				//Salvo id utente nella sessione
				request.getSession().setAttribute("user", user);
				request.getRequestDispatcher("views/todos.jsp").forward(request, response);
			}
			else {
				request.setAttribute("error", "Login Credentials are Not Correct!!!");
				request.getRequestDispatcher("views/login.jsp").forward(request, response);
			}
		}
		//Add toDO
		else if(request.getParameter("add") != null) {
			System.out.println("ADDD");
			String toDoTitle = request.getParameter("toDoTitle");
			String toDoText = request.getParameter("toDoText");
			User user = (User) request.getSession().getAttribute("user");
			DatabaseOperations.createToDo(toDoTitle, toDoText, user);
			Collection<ToDo> toDos = DatabaseOperations.getToDosForUser(user);
			request.setAttribute("toDos", toDos);
			request.getRequestDispatcher("views/todos.jsp").forward(request, response);
		}
		
		
		else if(request.getParameter("delete") != null) {
			int toDoId = Integer.parseInt(request.getParameter("toDoId"));
			
			User user = (User) request.getSession().getAttribute("user");
			DatabaseOperations.deleteToDo(user, toDoId);
			Collection<ToDo> toDos = DatabaseOperations.getToDosForUser(user);
			request.setAttribute("toDos", toDos);
			request.getRequestDispatcher("views/todos.jsp").forward(request, response);
		}
		
		else if(request.getParameter("update") != null) {
			int toDoId = Integer.parseInt(request.getParameter("toDoId"));
			String toDoTitle = request.getParameter("toDoTitle");
			String toDoText = request.getParameter("toDoText");
			User user = (User) request.getSession().getAttribute("user");
			
			DatabaseOperations.updateToDo(user, toDoId, toDoTitle, toDoText);
			Collection<ToDo> toDos = DatabaseOperations.getToDosForUser(user);
			request.setAttribute("toDos", toDos);
			request.getRequestDispatcher("views/todos.jsp").forward(request, response);
		}
		
		else if(request.getParameter("done") != null) {
			int toDoId = Integer.parseInt(request.getParameter("toDoId"));
			boolean toDoDone = Boolean.parseBoolean(request.getParameter("toDoDone"));
			System.out.println("DONE UPDATE TO: " + toDoDone);
			User user = (User) request.getSession().getAttribute("user");
			DatabaseOperations.updateToDoDone(user, toDoId, toDoDone);
			
			
			Collection<ToDo> toDos = DatabaseOperations.getToDosForUser(user);
			System.out.println(toDos);
			request.setAttribute("toDos", toDos);
			request.getRequestDispatcher("views/todos.jsp").forward(request, response);
			
		}
		
		else if(request.getParameter("logout") != null) {
			request.getSession().setAttribute("user", null);
			response.sendRedirect("/toDoHibernate");
		}
		
	}

}
