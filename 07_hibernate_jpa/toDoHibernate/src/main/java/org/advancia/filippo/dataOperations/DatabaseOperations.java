package org.advancia.filippo.dataOperations;



import java.util.Collection;
import java.util.List;

import org.advancia.filippo.model.ToDo;
import org.advancia.filippo.model.User;
import org.advancia.filippo.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class DatabaseOperations {
	
	public static User userLogin(String userName, String password) {
		
		Session session = HibernateUtil.currentSession();
		Transaction tx = null;
		try {
			
			User user = null;
		    tx = session.beginTransaction();//*******
		    
		    
			Query query = session.getNamedQuery("User.byNameAndPass");
			query.setString("name", userName);
			query.setString("pass", password);
			List<User> results = query.list();
			//Conviene controllare subito che il login sia andato a buon fine
			//E in tal caso recuperare anche i todos dell'utente
			System.out.println(results.size());
			if(results.size() > 0){
				user = results.get(0);
				Hibernate.initialize(user.getToDos()); //Serve per poter recuperare le lazy collections
											//Fuori dalla sessione
			}
				    
		    tx.commit();//********
		    return user;
		}
		catch (Exception e) {
		    if (tx!=null) tx.rollback();
		    throw e;
		}
		finally {
		    HibernateUtil.closeSession();
		}
			
		
	}
	
	
	public static Collection<ToDo> getToDosForUser(User user){
		
		Session session = HibernateUtil.currentSession();
		Transaction tx = null;
		try {
		    tx = session.beginTransaction();//*******
		    
		   Query query = session.getNamedQuery("ToDo.byUserId");
		   query.setInteger("id", user.getId());
		   List<ToDo> toDos = query.list();
		   for(ToDo t : toDos)
		    	System.out.println(t.getTitle());
		   	    
		    tx.commit();//********
		    
		    
		    
		    return toDos;
		}
		catch (Exception e) {
		    if (tx!=null) tx.rollback();
		    throw e;
		}
		finally {
		   HibernateUtil.closeSession();
		}
	}

	public static void createToDo(String toDoTitle, String toDoText, User user) {
		ToDo toDo = new ToDo();
		toDo.setTitle(toDoTitle);
		toDo.setText(toDoText);
		toDo.setUser(user);
		
		Session session = HibernateUtil.currentSession();
		Transaction tx = null;
		try {
		    tx = session.beginTransaction();//*******
		    
		    session.save(toDo);
			
				    
		    tx.commit();//********
		}
		catch (Exception e) {
		    if (tx!=null) tx.rollback();
		    throw e;
		}
		finally {
		    HibernateUtil.closeSession();
		}
		
	}
	
	
	public static void deleteToDo(User user, int toDoId) {
		
		ToDo toDo = new ToDo();
		toDo.setId(toDoId);
		toDo.setUser(user);
		
		Session session = HibernateUtil.currentSession();
		Transaction tx = null;
		try {
		    tx = session.beginTransaction();//*******
		    
		    session.delete(toDo);
			
				    
		    tx.commit();//********
		}
		catch (Exception e) {
		    if (tx!=null) tx.rollback();
		    throw e;
		}
		finally {
		    HibernateUtil.closeSession();
		}
	}
	
	public static void updateToDo(User user, int toDoId, String toDoTitle, String toDoText) {
			
			ToDo toDo = new ToDo();
			toDo.setId(toDoId);
			toDo.setText(toDoText);
			toDo.setTitle(toDoTitle);
			toDo.setUser(user);
			
			Session session = HibernateUtil.currentSession();
			Transaction tx = null;
			try {
			    tx = session.beginTransaction();//*******
			    
			    session.update(toDo);
				
					    
			    tx.commit();//********
			}
			catch (Exception e) {
			    if (tx!=null) tx.rollback();
			    throw e;
			}
			finally {
			    HibernateUtil.closeSession();
			}
		}
	
	public static void updateToDoDone(User user, int toDoId, boolean done) {
		ToDo toDo = null;	
		Session session = HibernateUtil.currentSession();
		Transaction tx = null;
		try {
		    tx = session.beginTransaction();//*******
		    
		    toDo = (ToDo) session.get(ToDo.class, toDoId);
		    //Ora ogni modifica si riflette come update
		    //Dato che l'oggetto è attached
		    toDo.setDone(done);
		    	    
		    tx.commit();//********
		}
		catch (Exception e) {
		    if (tx!=null) tx.rollback();
		    throw e;
		}
		finally {
		    HibernateUtil.closeSession();
		}
		
	}

	//Questa operazione recupera tutti i ToDo di un certo utente che contengono una certa keyword nel text
	//Viene usata la criteria APi
	public static Collection<ToDo> searchKeywordInText(User user, String keyword){
		Session session = HibernateUtil.currentSession();
		Transaction tx = null;
		Criteria criteria = session.createCriteria(ToDo.class); //Creo l'oggetto criteria per la classe desiderata
		//In questo caso il cretiria conterrà id utente e una like
		criteria.add(Restrictions.eq("user", user))//Ovviamente eq lavora sulla property e la relativa PK
				.add(Restrictions.ilike("text", keyword));
		
		try {
		    tx = session.beginTransaction();//*******
		    Collection<ToDo> toDos = criteria.list();
		    
		    tx.commit();//********
		    return toDos;
		}
		catch (Exception e) {
		    if (tx!=null) tx.rollback();
		    throw e;
		}
		finally {
		    HibernateUtil.closeSession();
		}
	}


	public static User userSignup(String userName, String password) {
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		
		Session session = HibernateUtil.currentSession();
		Transaction tx = null;
		
		
		try {
		    tx = session.beginTransaction();//*******
		    Query query = session.getNamedQuery("User.byName");
			query.setString("name", userName);
			List<User> results = query.list();
			//Se esiste già l'utente restituisci null al controller
			if(results.size() > 0)
				user = null;
			else 
				session.save(user); //Altrimenti aggiungi il nuovo utente
		    tx.commit();//********
		    return user;
		}
		catch (Exception e) {
		    if (tx!=null) tx.rollback();
		    throw e;
		}
		finally {
		    HibernateUtil.closeSession();
		}
	}

}
