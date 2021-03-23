package org.advancia.filippo.controller;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.advancia.filippo.model.CoffeeDataBean;

/**
 * Servlet implementation class CoffeServlet
 */
@WebServlet("/coffees")
public class CoffeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	//private Statement statement;
	private Context initContext;
	private Context envContext;
	private DataSource ds ;
	private CoffeeDataBean coffeeData;
	
	
	
	//Override di init
	@Override
	public void init(){
		try{
			this.initContext = new InitialContext();
	        this.envContext = (Context) initContext.lookup("java:comp/env");
	        this.ds = (DataSource) envContext.lookup("jdbc/dbCaffe");
	        this.connection = ds.getConnection();
	        //this.statement = this.connection.createStatement();
		}
        catch (NamingException ex) {
            System.err.println(ex);
        } catch (SQLException ex) {
            System.err.println(ex);
        }
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoffeeServlet() {
        super();
        System.out.println("Servlet Constructor!");
        try {
			this.coffeeData = new CoffeeDataBean(this.connection);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			request.setAttribute("coffeeData", this.coffeeData);
			RequestDispatcher dispatcher = request.getRequestDispatcher("views/coffeesListView.jsp");
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println("ACTION: " + action);
		String coffeeName = request.getParameter("coffeeName");
		System.out.println("COffee Name: " + coffeeName);
		
		if(action.equals("delete")){
			try {
				
				//this.coffeeData = new CoffeeDataBean(this.connection);
				this.coffeeData.deleteCoffee(coffeeName);
				request.setAttribute("coffeeData", this.coffeeData);
				RequestDispatcher dispatcher = request.getRequestDispatcher("views/coffeesListView.jsp");
				dispatcher.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
