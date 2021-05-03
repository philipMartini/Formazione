package org.advancia.filippo.business;

import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.advancia.filippo.model.ToDo;

/**
 * Session Bean implementation class ToDoFacade
 */
@Stateless
public class ToDoFacade implements ToDoFacadeLocal {
	
	@PersistenceContext(unitName = "toDoPersistence")
	EntityManager manager;

    /**
     * Default constructor. 
     */
    public ToDoFacade() {
        // TODO Auto-generated constructor stub
    }
    
   
	@Override
    public Collection<ToDo> getToDosByUserId(int userId) {
    	Query query = manager.createNamedQuery("ToDo.byUserId");
    	query.setParameter("id", userId);
    	List<ToDo> result = query.getResultList();
    	return result;
    }

}
