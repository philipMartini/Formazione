package org.filippo.formazione.todoapp.service;

import java.util.List;

import org.filippo.formazione.todoapp.model.ToDo;
import org.filippo.formazione.todoapp.model.User;
import org.filippo.formazione.todoapp.repository.ToDoRepository;
import org.filippo.formazione.todoapp.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {
	
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private ToDoRepository toDoRepository;

	public List<User> getAllUsers() {
		return (List<User>) this.usersRepository.findAll();
	}
	
	public User getUser(String userId) {
		return this.usersRepository.findById(userId).get();
	}

	public void addUser(User user) {
		this.usersRepository.save(user);
	}

	public void updateUser(String userId, User user) {
		//Se si cercasse di cambiare l'id nel body non sarebbe possibile
		//Perche viene considerato quello passato come path param
		user.setEmail(userId);
		this.usersRepository.save(user);
		
	}

	public void deleteUser(String userId) {
		this.usersRepository.deleteById(userId);
		
	}

	public List<ToDo> getToDosOfUser(String userId) {
		return this.toDoRepository.findByUserEmail(userId);
		
	}

	public void addToDo(ToDo toDo) {
		this.toDoRepository.save(toDo);
		
	}

}
