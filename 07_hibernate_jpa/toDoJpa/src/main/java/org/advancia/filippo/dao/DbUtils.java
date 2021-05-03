package org.advancia.filippo.dao;

import java.sql.Connection;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import org.advancia.filippo.model.User;


public class DbUtils {

	@PersistenceContext(unitName = "dataOpsUnit")
	protected static EntityManager em;
	@PersistenceUnit(unitName = "dataOpsUnit")
	protected static EntityManagerFactory emf;
	protected static EntityTransaction tx = null;
	protected static Connection conn = null;

	static
	{
		emf = Persistence.createEntityManagerFactory("dataOpsUnit");
		em = emf.createEntityManager();
		tx = em.getTransaction();
		em.clear();
	}

	public static void init(HttpSession p_session)
	{
		em.clear();
	}
	
	public static Collection<User> getAllUsers() {
		tx = em.getTransaction();
		tx.begin();
		Query query = em.createNamedQuery("User.allUsers");
		List<User> users = query.getResultList();
		System.out.println(users.get(1).getToDos().size());
		tx.commit();
		return users;
	}
	
}
