package org.advancia.filippo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.advancia.filippo.model.ToDo;

/**
 * Servlet implementation class ToDoController
 */
@WebServlet("/toDos")
public class ToDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, ToDo> toDos;
	private static final String create = "addToDo";
	private static final String delete = "deleteToDo";
	private static final String update = "updateToDo";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToDoController() {
        super();
        this.toDos = new HashMap<>();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Se la GET è per modificare un particolare ToDO
		if(request.getParameter("id") != null){
			generateToDoProfilePage(request, response);
		}
		
		else{
			//Altrimenti rimandami alla lista aggiornata dei ToDos
		//Setto l'attributo di sessione per i todos
			request.getSession().setAttribute("toDos", this.toDos.values());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/toDosHome.jsp");
			dispatcher.forward(request, response);
		}
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Attraverso i query parameters distinguiamo la create, update e delete
		if(request.getParameter(create) != null){
			System.out.println(request.getParameter(create));
			createToDo(request, response);	
		}
		
		else if(request.getParameter(delete) != null){
			deleteToDo(request, response);
		}
		
		else if(request.getParameter(update) != null){
			updateToDo(request, response);
		}
	}

	private void updateToDo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String toDoId = request.getParameter(update);
		System.out.println("UPDATE: " + toDoId);
		if(this.toDos.containsKey(toDoId)){
			try {
				this.toDos.get(toDoId).setTitle(request.getParameter("title"));
				this.toDos.get(toDoId).setText(request.getParameter("text"));
				//Aggiorna i todos
				request.getSession().setAttribute("toDos", this.toDos.values());
				//Manda il redirect alla home
				response.sendRedirect("views/toDosHome.jsp");
			} catch (InvalidToDoException e) {
				//Questo messaggio verrà visualizzato accanto alla textBox title
				request.setAttribute("errorMessage", e.getMessage());
				request.getRequestDispatcher("views/updateRemoveToDo.jsp?id="+toDoId).forward(request, response);
			}
			
		}
	}

	private void deleteToDo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String toDoId = request.getParameter(delete);
		if(this.toDos.containsKey(toDoId)){
			this.toDos.remove(toDoId);
		}
		//Aggiorna i todos
		request.getSession().setAttribute("toDos", this.toDos.values());
		//Manda il redirect alla home
		response.sendRedirect("views/toDosHome.jsp");
	}

	private void createToDo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String title = request.getParameter("title");
		String text = request.getParameter("text");
		try{
			ToDo toDo = new ToDo(title, text);
			this.toDos.put(toDo.getUuid().toString(), toDo);
			//Reindirizza alla home dei todos
			request.getSession().setAttribute("toDos", this.toDos.values());
			response.sendRedirect("views/toDosHome.jsp");
			
		}catch(InvalidToDoException e){
			System.out.println("Exception!");
			request.setAttribute("errorMessage", e.getMessage());
			request.getRequestDispatcher("views/addToDo.jsp").forward(request, response);
		}
	}
	
	private void generateToDoProfilePage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ToDo toDo = this.toDos.get(request.getParameter("id"));
		//System.out.println("TODO " + toDo);
		request.setAttribute("toDo", toDo); //Questo l'ho inserito per poter usare jspUseBean
		request.setAttribute("title", toDo.getTitle());
		request.setAttribute("text", toDo.getText());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/updateRemoveToDo.jsp");
		dispatcher.forward(request, response);
	}

}
