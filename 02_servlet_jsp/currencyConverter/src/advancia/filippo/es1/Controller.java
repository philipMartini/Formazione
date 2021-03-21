package advancia.filippo.es1;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet(description = "The controller for the currecy converter app", urlPatterns = { "/conversion" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CurrencyConverter converter;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        //this.converter = CurrencyConverter.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //Questo metodo deve solo restituire il form per effetuare la conversione
    //Saranno presenti due input select per la valuta from e to e una textbox per l'amount
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<form method=\"post\" action=\"conversion\">");
			out.print("Convert From:");
			out.print("<select name=\"fromCurrency\" multiple size=3>");
			out.print("<option value=\"USD\">USD</option>");
			out.print("<option value=\"EUR\">EUR</option>");
			out.print("<option value=\"GBP\">GBP</option>");
			out.print("<option value=\"JPY\">JPY</option>");
			out.print("<option value=\"CHF\">CHF</option>");
			out.print("<option value=\"CAD\">CAD</option>");
			out.print("<option value=\"NE\">NE</option>");
			out.print("</select>");
			out.print("Amount: <input name=\"amount\"/>");
			out.print("Convert To:");
			out.print("<select name=\"toCurrency\" multiple size=3>");
			out.print("<option value=\"USD\">USD</option>");
			out.print("<option value=\"EUR\">EUR</option>");
			out.print("<option value=\"GBP\">GBP</option>");
			out.print("<option value=\"JPY\">JPY</option>");
			out.print("<option value=\"CHF\">CHF</option>");
			out.print("<option value=\"CAD\">CAD</option>");
			out.print("<option value=\"NE\">NE</option>");
			out.print("</select>");
			out.print("<input type=\"submit\"/>");
			out.print("</form>");
		out.print("</body>");
		out.print("</html>");
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//SI potrebbe mettere nel costruttore ma è stato posizionato qui proprio per testare il SINGLETON
		this.converter = CurrencyConverter.getInstance();
		System.out.println("Number Of CurrencyCOnverter Instances: " + this.converter.getNumInstances());
		String fromCurrency = request.getParameter("fromCurrency");
		String toCurrency = request.getParameter("toCurrency");
		double amount = Double.parseDouble(request.getParameter("amount"));
		response.setContentType("text/html");
		
		try{
			double convertedAmount = this.converter.convertCurrency(fromCurrency, toCurrency, amount);
			DecimalFormat numberFormat = new DecimalFormat("#.00");
			PrintWriter out = response.getWriter();
			out.print("<html>");
			out.print("<body>");
				out.print("<h1>Converted Amount: " + numberFormat.format(convertedAmount) + "</h1>");
			out.print("</body>");
			out.print("</html>");
			out.close();
		}
		catch(CurrencyConversionException e){
			response.sendError(
		            HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
		            e.getMessage());
		}
	}

}
