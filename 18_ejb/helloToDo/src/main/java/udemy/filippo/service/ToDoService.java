package udemy.filippo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import udemy.filippo.entity.ToDo;

@Transactional
public class ToDoService {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public ToDo createToDo(ToDo toDo) {
		//Persist into Db
		this.entityManager.persist(toDo);
		return toDo;
	}
	
	
	public ToDo updateToDo(ToDo toDo) {
		this.entityManager.merge(toDo);
		return toDo;
	}
	
	public ToDo findToDoById(Long id) {
		return this.entityManager.find(ToDo.class, id);
	}
	
	public List<ToDo> getToDos(){
		return this.entityManager.createQuery("SELECT t FROM Todo t", ToDo.class).getResultList();
	}
	
}
