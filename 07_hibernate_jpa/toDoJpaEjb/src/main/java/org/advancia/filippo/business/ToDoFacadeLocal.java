package org.advancia.filippo.business;

import java.util.Collection;

import javax.ejb.Local;

import org.advancia.filippo.model.ToDo;

@Local
public interface ToDoFacadeLocal {

	Collection<ToDo> getToDosByUserId(int userId);

}
