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

import model.Persona;

public class DbUtils {

	@PersistenceContext(unitName = "JPAFirst")
	protected static EntityManager em;
	@PersistenceUnit(unitName = "JPAFirst")
	protected static EntityManagerFactory emf;
	protected static EntityTransaction tx = null;
	protected static Connection conn = null;

	static
	{
		emf = Persistence.createEntityManagerFactory("JPAFirst");
		em = emf.createEntityManager();
		tx = em.getTransaction();
		em.clear();
	}

	public static void init(HttpSession p_session)
	{
		em.clear();
	}
	
	public static List<Persona> selectAllPersone(){
		Query selectAll = em.createQuery("SELECT p FROM Persona p");
		@SuppressWarnings("unchecked")
		List<Persona> list = selectAll.getResultList();
		return list;		
	}
}
