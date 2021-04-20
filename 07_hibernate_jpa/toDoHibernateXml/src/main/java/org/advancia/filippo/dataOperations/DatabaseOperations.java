package org.advancia.filippo.dataOperations;



import java.util.Collection;
import java.util.List;

import org.advancia.filippo.model.ToDo;
import org.advancia.filippo.model.User;
import org.advancia.filippo.utils.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DatabaseOperations {
	
	public static User userLogin(String userName, String password) {
		
		Session session = HibernateUtil.currentSession();
		Transaction tx = null;
		try {
			
			User user = null;
		    tx = session.beginTransaction();//*******
		    
		    
			Query query = session.getNamedQuery("BYNAMEANDPASS");
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
		    
		   Query query = session.getNamedQuery("BYUSERID");
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

	

}
