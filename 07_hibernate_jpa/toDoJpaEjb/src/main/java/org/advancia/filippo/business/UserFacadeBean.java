package org.advancia.filippo.business;

import java.util.Collection;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.advancia.filippo.model.ToDo;
import org.advancia.filippo.model.User;




/**
 * Session Bean implementation class UserFacadeBean
 */
@Stateless
@EJB(beanInterface = UserFacadeBeanLocal.class, beanName = "userBean", name = "userFacade")
public class UserFacadeBean implements UserFacadeBeanRemote, UserFacadeBeanLocal {
	
	@PersistenceContext(unitName = "toDoPersistence")
	EntityManager manager;

    /**
     * Default constructor. 
     */
    public UserFacadeBean() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public Collection<ToDo> getToDosByUserId(int userId) {
    	Query query = manager.createNamedQuery("ToDo.byUserId");
    	query.setParameter("id", userId);
    	List<ToDo> result = query.getResultList();
    	return result;
    }
    
    
    public User getUserByIdAndPassword(String userName, String password) {
    	
    	Query query = manager.createNamedQuery("User.byNameAndPass");
    	query.setParameter("name", userName);
    	query.setParameter("pass", password);
    	User user = null;
    	try {
    		user = (User) query.getSingleResult();
    		//Data l'inizializzazione Lazy se hai trovato l'utente fetcha anche i suoi todos
    		System.out.println(user.getToDos().size());
    	}catch(NoResultException e) {
    		user = null;
    	}
    	
    	return user;
    }

	@Override
	public void addToDo(ToDo toDo) {
		manager.persist(toDo);
		
	}

	@Override
	public void deleteToDo(int toDoId) {
	
		ToDo toDo = manager.find(ToDo.class, toDoId);
		
		manager.remove(toDo);
		
	}

	@Override
	public void updateToDo(int toDoId, String toDoTitle, String toDoText) {
		ToDo toDo = manager.find(ToDo.class, toDoId);
		toDo.setTitle(toDoTitle);
		toDo.setText(toDoText);
		
	}

	@Override
	public void updateDoneValue(int toDoId, boolean doneValue) {
		ToDo toDo = manager.find(ToDo.class, toDoId);
		toDo.setDone(doneValue);
		
	}

	@Override
	public void addUser(User user) {
		manager.persist(user);
		System.out.println(user.getId());
	}

	@Override
	public User getUserByName(String userName) {
		Query query = manager.createNamedQuery("User.byName");
		query.setParameter("name", userName);
		User user = null;
		
		try {
    		user = (User) query.getSingleResult();
    		
    	}catch(NoResultException e) {
    		user = null;
    	}
    	
    	return user;
		
	}

	@Override
	public Collection<User> getAllUsers() {
		Query query = manager.createNamedQuery("User.allUsers");
		List<User> users = query.getResultList();
		return users;
	}

	@Override
	public User getUserById(int userId) {
		Query query = manager.createNamedQuery("User.byId");
		query.setParameter("user_id", userId);
		User user = null;
		
		try {
    		user = (User) query.getSingleResult();
    		
    	}catch(NoResultException e) {
    		user = null;
    	}
    	
    	return user;
	}

	@Override
	public void deleteUserById(int id) {
		User user = manager.find(User.class, id);
		if(user != null) {
			manager.remove(user);
		}
		
	}
}
