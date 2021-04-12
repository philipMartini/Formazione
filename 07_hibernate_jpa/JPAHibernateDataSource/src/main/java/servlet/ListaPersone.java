package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DbUtils;
import model.Macchina;
import model.Persona;
import model.Corso;

/**
 * Servlet implementation class ListaPersone
 */
@WebServlet("/pippo")
public class ListaPersone extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaPersone() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
//		String nome = request.getParameter("nome");
//		int idPersona = Integer.parseInt(request.getParameter("idPersona"));
		
		//DbUtils.modificaNome(idPersona,nome);
		List<Persona> listaPersone = DbUtils.selectAllPersone();
//		for(Persona p: listaPersone)
//		{
//			System.out.println(p.getIdPersona());
//			System.out.println(p.getCognome());
//			System.out.println(p.getNome());
//			System.out.println(p.getDataNascita());
//		}
		
		System.out.println("============= RELAZIONE MOLTI A UNO ==========");
		List<Macchina> listaMacchine = DbUtils.selectAllMacchine();
		for(Macchina m: listaMacchine)
		{
			System.out.println("ID MACCHINA: " + m.getIdMacchina());
			System.out.println("MODELLO: " + m.getModello());
			System.out.println("COGNOME: " + m.getPersona().getCognome());
		}
		
		System.out.println("============= RELAZIONE UNO A MOLTI ==========");
		listaPersone = DbUtils.selectAllPersone();
		for(Persona p: listaPersone)
		{
			System.out.println("ID PERSONA: " + p.getIdPersona());
			System.out.println("COGNOME: " + p.getCognome());
			System.out.println("NOME: " + p.getNome());
			System.out.println("DATA NASCITA:" + p.getDataNascita());

			for(Macchina m: p.getMacchine()){
				System.out.println("ID MACCHINA: " + m.getIdMacchina());
				System.out.println("MODELLO: " + m.getModello());
			}
		}
		
		System.out.println("============= RELAZIONE MOLTI A MOLTI ==========");
		List<Corso> listaCorsi = DbUtils.selectAllCorsi();
		for(Corso c: listaCorsi){
			System.out.println("ID CORSO: "+ c.getIdCorso());
			System.out.println("ID_DESCR: " + c.getDescrizione());
			
			for(Persona p: c.getPersone()){
				System.out.println("ID PERSONA: " + p.getIdPersona());
				System.out.println("COGNOME: " + p.getCognome());
				System.out.println("NOME: " + p.getNome());
			}
		}
		request.getSession().setAttribute("listaPersone", listaPersone);
		request.getSession().setAttribute("listaMacchine", listaMacchine);
		request.getSession().setAttribute("listaCorsi", listaCorsi);
		request.getRequestDispatcher("result.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
