package org.advancia.filippo.controller;

import java.io.IOException;
import java.util.Collection;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.advancia.filippo.business.UserFacadeBeanLocal;
import org.advancia.filippo.model.ToDo;
import org.advancia.filippo.model.User;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/todos")
@MultipartConfig
public class ToDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private UserFacadeBeanLocal userService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToDoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*getTodos(request, response);*/
		
		
			System.out.println("ASYNC REQ");
		
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			System.out.println("POST REQ");
			
			
			
			//Login
			if(request.getParameter("login") != null) {
				System.out.println("Login Req");
				login(request, response);
			}
			
			//Logout
			if(request.getParameter("logout") != null) {
				System.out.println("Logout req");
				logout(request, response);
			}
			
			if(request.getParameter("signup") != null) {
				
				String userName = request.getParameter("username");
				String password = request.getParameter("password");
				System.out.println(userName);
				System.out.println(password);
				User user = this.userService.getUserByName(userName);
				System.out.println(user);
				if(user == null) {
					
					user = new User();
					user.setUserName(userName);
					user.setPassword(password);
					
					this.userService.addUser(user);
					
					//Setta l'utente nella sessione
					request.getSession().setAttribute("user", user);
					
					//Recupera i suoi todos
					Collection<ToDo> todos = user.getToDos();
					
					//Settali nella req
					request.setAttribute("todos", todos);
					
					
					//Inoltra la richiesta
					request.getRequestDispatcher("views/todos.jsp").forward(request, response);
				}
				else {
					System.out.println("Erorr Signup");
					request.setAttribute("error", "User Is Already Registered!");
					request.getRequestDispatcher("views/signup.jsp").forward(request, response);
					
					
				}
				
			}
			
			if(request.getParameter("add") != null) {
				System.out.println("Add Req");
				addToDo(request, response);
			}
			if(request.getParameter("delete") != null) {
				deleteToDo(request, response);
			}
			
			if(request.getParameter("update") != null) {
				int toDoId = Integer.parseInt(request.getParameter("toDoId"));
				String toDoTitle = request.getParameter("toDoTitle");
				String toDoText = request.getParameter("toDoText");
				
				this.userService.updateToDo(toDoId, toDoTitle, toDoText);
				this.getTodos(request, response);
				
			}
			
			if(request.getParameter("done") != null) {
				updateDoneValue(request);
			}
			
			
			
			
		}

	private void updateDoneValue(HttpServletRequest request) {
		int toDoId = Integer.parseInt(request.getParameter("toDoId"));
		boolean oldDoneValue = Boolean.parseBoolean(request.getParameter("doneValue"));
		boolean newDoneValue = false;
		if(!oldDoneValue)
			newDoneValue = true;
		
			
		this.userService.updateDoneValue(toDoId, newDoneValue);
		System.out.println(oldDoneValue);
		System.out.println(newDoneValue);
		System.out.println(toDoId);
	}

	private void deleteToDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Delete Req");
		int toDoId = Integer.parseInt(request.getParameter("toDoId"));
		this.userService.deleteToDo(toDoId);
		this.getTodos(request, response);
	}

	private void addToDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String toDoTitle = request.getParameter("toDoTitle");
		String toDoText = request.getParameter("toDoText");
		User user = (User) request.getSession().getAttribute("user");
		ToDo toDo = new ToDo();
		toDo.setTitle(toDoTitle);
		toDo.setText(toDoText);
		toDo.setUser(user);
		this.userService.addToDo(toDo);
		this.getTodos(request, response);
	}

	private void getTodos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if(user != null) {
			Collection<ToDo> todos = this.userService.getToDosByUserId(user.getId());
			request.setAttribute("todos", todos);
			request.getRequestDispatcher("views/todos.jsp").forward(request, response);
		}else {
			response.sendRedirect("views/login.jsp");
		}
	}
	
	
	
	


	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().setAttribute("user", null);
		response.sendRedirect("views/login.jsp");
	}
	
	

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(userName);
		System.out.println(password);
		User user = this.userService.getUserByIdAndPassword(userName, password);
		System.out.println(user);
		if(user != null) {
			//Setta l'utente nella sessione
			request.getSession().setAttribute("user", user);
			
			//Recupera i suoi todos
			Collection<ToDo> todos = user.getToDos();
			
			//Settali nella req
			request.setAttribute("todos", todos);
			
			
			//Inoltra la richiesta
			request.getRequestDispatcher("views/todos.jsp").forward(request, response);
		}
		else {
			System.out.println("Erorr login");
			request.setAttribute("error", "Username Or PassWord Is Incorrect!");
			request.getRequestDispatcher("views/login.jsp").forward(request, response);
		}
	}

}
