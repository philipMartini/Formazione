package org.advancia.filippo.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.advancia.filippo.dataOps.DatabaseOperations;
import org.advancia.filippo.model.ToDoBean;


/**
 * Servlet implementation class ToDosServlet
 */
@WebServlet("/toDos")
public class ToDosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToDosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//System.out.println("DATE " + new Date());
		//Per ora ci limitiamo a stampare i todos presenti
		String wait = request.getParameter("wait");
		List<ToDoBean> toDos;
		
		if(request.getParameter("add") != null){
			System.out.println("ADD!!!!");
			String title = request.getParameter("title");
			String text = request.getParameter("text");
			DatabaseOperations.addToDo(new ToDoBean(title, text));
		}
		
		
		/*if(wait.equals("true")){
			System.out.println("GET CALL WITH WAIT!");
		
			toDos = DatabaseOperations.getToDos();
		}
		else{
			System.out.println("GET CALL NO WAIT!");
			toDos = DatabaseOperations.getToDosNoSleep();
		}*/
		toDos = DatabaseOperations.getToDos();
		request.getSession().setAttribute("toDos", toDos);
		response.sendRedirect("toDosList.jsp");
		//RequestDispatcher dispatcher = request.getRequestDispatcher("toDosList.jsp");
		//dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("add") != null){
			System.out.println("ADD!!!!");
			String title = request.getParameter("title");
			String text = request.getParameter("text");
			DatabaseOperations.addToDo(new ToDoBean(title, text));
		}
		else if(request.getParameter("delete") != null){
			System.out.println("DELETE");
			int id = Integer.parseInt(request.getParameter("id"));
			DatabaseOperations.deleteToDo(id);
		}
		
		else if(request.getParameter("update") != null){
			System.out.println("UPDATE");
			String title = request.getParameter("title");
			String text = request.getParameter("text");
			int id = Integer.parseInt(request.getParameter("id"));
			DatabaseOperations.updateToDO(new ToDoBean(id, title, text));
		}
		
		List<ToDoBean> toDos;
		toDos = DatabaseOperations.getToDos();
		request.getSession().setAttribute("toDos", toDos);
		response.sendRedirect("toDosList.jsp");
	}

}
