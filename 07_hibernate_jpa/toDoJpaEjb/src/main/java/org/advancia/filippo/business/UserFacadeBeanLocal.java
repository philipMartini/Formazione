package org.advancia.filippo.business;

import java.util.Collection;

import javax.ejb.Local;

import org.advancia.filippo.model.ToDo;
import org.advancia.filippo.model.User;

@Local
public interface UserFacadeBeanLocal {
	
	User getUserByIdAndPassword(String userName, String password);
	
	User getUserByName(String userName);

	Collection<ToDo> getToDosByUserId(int userId);

	void addToDo(ToDo toDo);

	void deleteToDo(int toDoId);

	void updateToDo(int toDoId, String toDoTitle, String toDoText);

	void updateDoneValue(int toDoId, boolean doneValue);

	void addUser(User user);

	Collection<User> getAllUsers();

	User getUserById(int id);

	void deleteUserById(int id);
}
