package org.advancia.filippo;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.advancia.filippo.CurrencyConversionException;
import org.advancia.filippo.CurrencyConverter;

/**
 * Servlet implementation class Controller
 */
@WebServlet(description = "A Simple Servlet That interacts with a JSP page", urlPatterns = { "/converter" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CurrencyConverter converter;
       
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
		this.converter = CurrencyConverter.getInstance();
		request.getSession().setAttribute("currencies", this.converter.getCurrencies());
		if(request.getSession().getAttribute("requestsNumb") == null)
			request.getSession().setAttribute("requestsNumb", 0);
		//Alla GET non c'è nessun amount da convertire quindi lascia una stringa vuota
		request.setAttribute("convertedAmount", "");
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/converter.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.converter = CurrencyConverter.getInstance();
		System.out.println("Number Of CurrencyCOnverter Instances: " + this.converter.getNumInstances());
		
		//Se avviene una post la get è gia avveuta => quindi lattributo di sessione è gia settato
		int reqNumb = (int) request.getSession().getAttribute("requestsNumb");
		request.getSession().setAttribute("requestsNumb", ++reqNumb);
	
		
		String fromCurrency = request.getParameter("fromCurrency");
		String toCurrency = request.getParameter("toCurrency");
		double amount = Double.parseDouble(request.getParameter("amount"));
		
		try{
			double convertedAmount = this.converter.convertCurrency(fromCurrency, toCurrency, amount);
			DecimalFormat numberFormat = new DecimalFormat("#.00");
			request.setAttribute("convertedAmount", numberFormat.format(convertedAmount));
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/converter.jsp");
			dispatcher.forward(request, response);
		}
		catch(CurrencyConversionException e){
			response.sendError(
		            HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
		            e.getMessage());
		}
	}

}
