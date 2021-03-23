package org.advancia.filippo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class SurveyServlet
 */
@WebServlet("/animalSurvey")
public class SurveyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	private Statement statement;
	private Context initContext;
	private Context envContext;
	private DataSource ds ;
	
	
	
	//Override di init
	@Override
	public void init(){
		
		try{
			this.initContext = new InitialContext();
	        this.envContext = (Context) initContext.lookup("java:comp/env");
	        this.ds = (DataSource) envContext.lookup("jdbc/animalsurvey");
	        this.connection = ds.getConnection();
	        this.statement = this.connection.createStatement();
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
    public SurveyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		//Head del documento
		
		
		int value = Integer.parseInt( request.getParameter("animal"));
		
		String query;
		
		//Tenta di elaborare un voto e visualizza il risultato corrente
		try{
			
			//Aggiorna totale per rispsota corrrente del quest
			query = "UPDATE surveyresults SET votes = votes + 1 " + 
					"WHERE id= " + value;
			//Effettua la update
			statement.executeUpdate(query);
			
			//Ora recupera i risultati aggiornati
			//Prima il totale dei voti......
			query = "SELECT sum( votes ) FROM surveyresults";
			ResultSet totalRS = statement.executeQuery(query);
			//Muovi il cursore sulla prima riga valida
			totalRS.next();
			int total = totalRS.getInt(1);
			//...Poi i risultati del sondaggio
			query = "SELECT surveyoption, votes, id FROM surveyresults " + 
					"ORDER BY id";
			ResultSet resultsRS = statement.executeQuery(query);
			
			//Presenta i risultati
			
			out.println("<head>");
			out.println("<title>Thank You!</title>");
			out.println("</head>");
			
			//Body
			out.println("<body>");
			out.println("<p> Thank You for Partecipating. ");
			out.println("<br>Results:</p><pre>");
			
			int votes;
			DecimalFormat numberFormat  = new DecimalFormat("#.00");
			while(resultsRS.next()){
				out.print(resultsRS.getString(1));
				out.print(": ");
				votes = resultsRS.getInt(2);
				double percentResult =  (((double)votes) / total) * 100;
				System.out.println(percentResult);
				out.print(numberFormat.format(percentResult));
				out.print(" % responses: ");
				out.println(votes);
			}
			
			//Chiudo il ResultSet
			resultsRS.close();
			
			out.print("Total Responses: " + total);
			out.println("<br>");
			
			out.println("<a href=\"views/survey.html\">Vote Again!</a>");

			out.println("</pre></body>");
			
			out.println("</html>");
			out.close();
		}catch(SQLException e){
			e.printStackTrace();
			out.println( "<title>Error</title>" );
        	out.println( "</head>" );  
        	out.println( "<body><p>Database error occurred. " );
        	out.println( "Try again later.</p></body></html>" );
        	out.close();
			
		}
		
	}
	
	@Override
	public void destroy(){
		//Tenta di chiudere la connessione al DB
		
		try {
			this.statement.close();
			this.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	
	}

}
