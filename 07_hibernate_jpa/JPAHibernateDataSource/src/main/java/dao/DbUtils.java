package dao;

import java.sql.Connection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import model.Corso;
import model.Macchina;
import model.Persona;

public class DbUtils {

	@PersistenceContext(unitName = "JPAHibernateDataSource")
	protected static EntityManager em;
	@PersistenceUnit(unitName = "JPAHibernateDataSource")
	protected static EntityManagerFactory emf;
	protected static EntityTransaction tx = null;
	protected static Connection conn = null;

	static
	{
		emf = Persistence.createEntityManagerFactory("JPAHibernateDataSource");
		em = emf.createEntityManager();
		tx = em.getTransaction();
		em.clear();
	}

	public static void init(HttpSession p_session)
	{
		em.clear();
	}
	
	public static List<Persona> selectAllPersone(){
		Query selectAll = em.createQuery("SELECT p FROM Persone p");
		@SuppressWarnings("unchecked")
		List<Persona> list = selectAll.getResultList();
		return list;		
	}
	
	public static List<Corso> selectAllCorsi(){
		Query selectAll = em.createQuery("SELECT c FROM Corsi c");
		@SuppressWarnings("unchecked")
		List<Corso> list = selectAll.getResultList();
		return list;
	}
	
	public static List<Macchina> selectAllMacchine(){
		Query selectAll = em.createQuery("SELECT m FROM Macchine m");
		@SuppressWarnings("unchecked")
		List<Macchina> list = selectAll.getResultList();
		return list;
	}
	
	public static void modificaNome(int idPersona, String nome){
		
		tx.begin();
		String queryStr = "SELECT p FROM Persone p WHERE p.idPersona="+idPersona;
		
		Query selectPersona = em.createQuery(queryStr);
		Persona pers = (Persona) selectPersona.getSingleResult();
		pers.setNome(nome);
		em.persist(pers);
		tx.commit();
	}
}
