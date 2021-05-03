package org.advancia.filippo.data.util;

import java.sql.Connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.advancia.filippo.model.User;

public class DataOperations {
	
	@PersistenceContext(unitName = "dataOpsUnit")
	protected static EntityManager em;
	@PersistenceUnit(unitName = "dataOpsUnit")
	protected static EntityManagerFactory emf;
	protected static EntityTransaction tx = null;
	protected static Connection conn = null;

	/*static
	{
		emf = Persistence.createEntityManagerFactory("dataOpsUnit");
		em = emf.createEntityManager();
		tx = em.getTransaction();
		em.clear();
	}*/
	
	
	public static User userLogin(String username, String password) {
		emf = Persistence.createEntityManagerFactory("dataOpsUnit");
		em = emf.createEntityManager();
		tx = em.getTransaction();
		Query query = em.createNamedQuery("User.byNameAndPass");
    	query.setParameter("name", username);
    	query.setParameter("pass", password);
    	User user = null;
    	try {
    		user = (User) query.getSingleResult();
    		//Data l'inizializzazione Lazy se hai trovato l'utente fetcha anche i suoi todos
    		System.out.println(user.getToDos().size());
    		tx.commit();
    	}catch(Exception e) {
    		user = null;
    		tx.rollback();
    	}
    	
    	return user;
	}

}
