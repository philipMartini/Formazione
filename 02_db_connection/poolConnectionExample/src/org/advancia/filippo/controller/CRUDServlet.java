package org.advancia.filippo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.advancia.filippo.dataOperations.DatabaseOperation;
import org.advancia.filippo.model.Person;

/**
 * Servlet implementation class CRUDServlet
 */
@WebServlet("/CRUDServlet")
public class CRUDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// usati per fare update
	private final static String CHANGE = "edit";
	private final static String DO_CHANGE = "Change";
	private final static String EDIT = "editRequest";
	// usati per fare insert
	private final static String ADD = "add";
	private final static String DO_ADD = "Add";
	// usato per fare select
	private final static String SELECT = "select";
	// usati per fare delete
	private final static String DELETE = "delete";
	private final static String DO_DELETE = "Delete";

	private static final String HOME = "Home";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CRUDServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		System.out.println("The requested operation is " + op);
		
		if (op.equals(SELECT)) {
			request.setAttribute("action", SELECT);
			showDBContent(request, response);
		} else if (op.equals(ADD)) {
			/*
			 * Set the next action to DO_ADD
			 * Set empty strings to the edit page
			 * Forward to CRUDEdit.jsp
			 */
			request.setAttribute("action", DO_ADD);
			request.setAttribute("actionName", "Add");
			request.setAttribute("firstName", "");
			request.setAttribute("lastName", "");
			request.setAttribute("age", "");
			Person p = new Person(-1,"","",-1);
			request.setAttribute("person", p);
			
			RequestDispatcher postino = request.getRequestDispatcher("editTable.jsp");
			postino.forward(request, response);
		} else if(op.equals(CHANGE)) {
			/*
			 * Set the next action to DO_CHANGE
			 * Set the ID to the given ID
			 * Set the text fields to the actual values
			 * Forward to CRUDEdit.jsp
			 */
			request.setAttribute("action", DO_CHANGE);
			request.setAttribute("actionName", "Edit");
			
			int id = Integer.parseInt(request.getParameter("id"));
			Person p = DatabaseOperation.getPersonByID(id);
			
			request.setAttribute("person", p);
			request.setAttribute("firstName", p.getFirstName());
			request.setAttribute("lastName", p.getLastName());
			request.setAttribute("age", p.getAge());
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("editTable.jsp");
			dispatcher.forward(request, response);
		} else if (op.equals(DELETE)) {
			/*
			 * Delete the given ID
			 * Read the DB table
			 * Forward to CRUDExec.jsp
			 */
			request.setAttribute("action", DELETE);
			//int id = Integer.parseInt(request.getParameter("idToDelete"));
			//DatabaseOperation.deletePersonByID(id);
			showDBContent(request, response);
		} else if (op.equals(DO_ADD)) {
			/*
			 * Reads the data
			 * Adds the person
			 * Read the DB table
			 * Forward to CRUDExec.jsp
			 */
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			int age = Integer.parseInt(request.getParameter("age"));
			
			System.out.println("Adding person with fn=" + firstName + ", ln=" + lastName + ", age=" + age);
			DatabaseOperation.addPerson(new Person(-1, firstName, lastName, age));
			RequestDispatcher dispatcher = request.getRequestDispatcher("CRUDServlet?op=select");
			dispatcher.forward(request, response);
		} else if (op.equals(DO_CHANGE)) {
			/*
			 * Reads the data
			 * Edit the person
			 * Read the DB table
			 * Forward to CRUDExec.jsp
			 */
			int id = Integer.parseInt(request.getParameter("id"));
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			int age = Integer.parseInt(request.getParameter("age"));
			
			DatabaseOperation.editPersonById(id, new Person(-1, firstName, lastName, age));
			request.setAttribute("action", SELECT);
			RequestDispatcher dispatcher = request.getRequestDispatcher("CRUDServlet?op=select");
			dispatcher.forward(request, response);
		} else if(op.equals(EDIT)) {
			request.setAttribute("action", EDIT);
			showDBContent(request, response);
		} else if(op.equals(DO_DELETE)) {
			int id = Integer.parseInt(request.getParameter("id"));
			DatabaseOperation.deletePersonByID(id);
			request.setAttribute("action", SELECT);
			RequestDispatcher dispatcher = request.getRequestDispatcher("CRUDServlet?op=select");
			dispatcher.forward(request, response);
		} else if(op.equals(HOME)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void showDBContent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Person> people = DatabaseOperation.readPeopleTable();
		request.setAttribute("people", people);
		RequestDispatcher dispatcher = request.getRequestDispatcher("showTable.jsp");
		dispatcher.forward(request, response);
	}

}
