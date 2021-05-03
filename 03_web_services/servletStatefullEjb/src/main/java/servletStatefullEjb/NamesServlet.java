package servletStatefullEjb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/names")
public class NamesServlet extends HttpServlet {
   
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//@EJB
    //private NamesBean names;
    //private  List<String> list;
	@Inject
	NamesBean names;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, NamingException {
    	
    	// names = (NamesBean) new InitialContext().lookup("java:comp/env/ejb/NamesBean");
        List<String> list;
        System.out.println("GET REQ");    	
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            names.addName(request.getParameter("name"));
            list = names.getNames();

            out.println("<html>");
            out.println("<head>");
            out.println("<title>NamesServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>Current List of Names</h3>");
            for(String name: list) {
                out.println(name  + "<br>");
            }
            out.println("</body>");
            out.println("</html>");
            
        } finally {
            System.out.println("Error");
            out.close();
            //request.getSession().invalidate();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
			processRequest(request, response);
		} catch (ServletException | IOException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
			processRequest(request, response);
		} catch (ServletException | IOException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
