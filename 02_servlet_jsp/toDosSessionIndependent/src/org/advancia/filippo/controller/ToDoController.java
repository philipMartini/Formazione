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
	//In questo caso non voglio che tutte le sessioni condividano la stessa collezione
	//Ma che la lista dei todos sia indipendente per ogni sessione
	//L'idea è salvare l'intera collezione nello scope di sessione
	//E recuperarlo prima di ogni operazione e settare l'attributo aggiornato
	//private Map<String, ToDo> toDos;
	private static final long serialVersionUID = 1L;
	private static final String create = "addToDo";
	private static final String delete = "deleteToDo";
	private static final String update = "updateToDo";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToDoController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//L'attributo viene settato nella jsp toDOsHome	
		Map<String, ToDo> toDos = (Map<String, ToDo>) request.getSession().getAttribute("toDos");
		//Se la GET è per modificare un particolare ToDO
		if(request.getParameter("id") != null){
			generateToDoProfilePage(toDos, request, response);
		}
		
		else{
			//Altrimenti rimandami alla lista aggiornata dei ToDos
		//Setto l'attributo di sessione per i todos (NON DOVREBBE ESSERE ESEGUITO)
			if(request.getSession().getAttribute("toDos") == null){
				System.out.println("CREATING TODOS");
				toDos = new HashMap<>();
				//Conservo l'intera collezione nella sessione
				request.getSession().setAttribute("toDos", toDos);
			}
			//request.getSession().setAttribute("toDos", this.toDos.values());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/toDosHome.jsp");
			dispatcher.forward(request, response);
		}
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, ToDo> toDos = (Map<String, ToDo>) request.getSession().getAttribute("toDos");
		//Attraverso i query parameters distinguiamo la create, update e delete
		if(request.getParameter(create) != null){
			System.out.println(request.getParameter(create));
			createToDo(toDos, request, response);	
		}
		
		else if(request.getParameter(delete) != null){
			deleteToDo(toDos, request, response);
		}
		
		else if(request.getParameter(update) != null){
			updateToDo(toDos, request, response);
		}
	}

	private void updateToDo(Map<String, ToDo> toDos, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String toDoId = request.getParameter(update);
		System.out.println("UPDATE: " + toDoId);
		if(toDos.containsKey(toDoId)){
			try {
				toDos.get(toDoId).setTitle(request.getParameter("title"));
				toDos.get(toDoId).setText(request.getParameter("text"));
				//Aggiorna i todos
				request.getSession().setAttribute("toDos", toDos);
				//Manda il redirect alla home
				response.sendRedirect("views/toDosHome.jsp");
			} catch (InvalidToDoException e) {
				//Questo messaggio verrà visualizzato accanto alla textBox title
				request.setAttribute("errorMessage", e.getMessage());
				request.getRequestDispatcher("views/updateRemoveToDo.jsp?id="+toDoId).forward(request, response);
			}
			
		}
	}

	private void deleteToDo(Map<String, ToDo> toDos, HttpServletRequest request, HttpServletResponse response) throws IOException {
		String toDoId = request.getParameter(delete);
		if(toDos.containsKey(toDoId)){
			toDos.remove(toDoId);
		}
		//Aggiorna i todos
		request.getSession().setAttribute("toDos", toDos);
		//Manda il redirect alla home
		response.sendRedirect("views/toDosHome.jsp");
	}

	private void createToDo(Map<String, ToDo> toDos, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String title = request.getParameter("title");
		String text = request.getParameter("text");
		System.out.println("CREATE: " + toDos);
		try{
			ToDo toDo = new ToDo(title, text);
			toDos.put(toDo.getUuid().toString(), toDo);
			//Reindirizza alla home dei todos
			request.getSession().setAttribute("toDos", toDos);
			response.sendRedirect("views/toDosHome.jsp");
			
		}catch(InvalidToDoException e){
			System.out.println("Exception!");
			request.setAttribute("errorMessage", e.getMessage());
			request.getRequestDispatcher("views/addToDo.jsp").forward(request, response);
		}
	}
	
	private void generateToDoProfilePage(Map<String, ToDo> toDos, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Generate Profile!");
		System.out.println("TODOS " + toDos);
		ToDo toDo = toDos.get(request.getParameter("id"));
		request.setAttribute("toDo", toDo); //Questo l'ho inserito per poter usare jspUseBean
		request.setAttribute("title", toDo.getTitle());
		request.setAttribute("text", toDo.getText());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/updateRemoveToDo.jsp");
		dispatcher.forward(request, response);
	}

}
