package org.filippo.formazione.todoapp.repository;

import java.util.List;

import org.filippo.formazione.todoapp.model.ToDo;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDo, Integer> {

	List<ToDo> findByUserEmail(String userId);
	
	
}
