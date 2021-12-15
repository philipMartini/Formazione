package org.filippo.formazione.todoapp.controller;

import java.util.Date;
import java.util.List;

import org.filippo.formazione.todoapp.model.ToDo;
import org.filippo.formazione.todoapp.model.User;
import org.filippo.formazione.todoapp.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/todo-app")
public class ToDoAppController {
	
	@Autowired
	private BusinessService service;
	
	
	@GetMapping(path = "/users")
	public List<User> getUsers(){
		return this.service.getAllUsers();
	}
	
	@GetMapping(path = "/users/{userId}")
	public User getUser(@PathVariable(value = "userId") String userId) {
		System.out.println(userId);
		return this.service.getUser(userId);
	}
	
	@PostMapping(path = "/users")
	public void addUser(@RequestBody User user) {
		System.out.println(user);
		this.service.addUser(user);
	}
	
	@PutMapping(path = "/users/{userId}")
	public void updateUser(@PathVariable(value = "userId") String userId, @RequestBody User user) {
		
		this.service.updateUser(userId, user);
	}
	
	@DeleteMapping(path = "/users/{userId}")
	public void deleteUser(@PathVariable(value = "userId") String userId) {
		this.service.deleteUser(userId);
	}
	
	
	@GetMapping(path = "/users/{userId}/todos")
	public List<ToDo> getToDosOfUser(@PathVariable(value = "userId") String userId){
		//Potrei anche recuperare l'utente ma è meglio sperimentare aggiugendo una ToDoRepo
		return this.service.getToDosOfUser(userId);
	}
	
	@PostMapping(path = "/users/{userId}/todos")
	public void addToDoForUser(@PathVariable(value = "userId") String userId, @RequestBody ToDo toDo) {
		//Setto id a partire dal pathparam e non condero iquello settato nel body
		User tmpUser = new User();
		tmpUser.setEmail(userId);
		toDo.setUser(tmpUser);
		toDo.setCreationDate(new Date());
		this.service.addToDo(toDo);
		
		
	}
}
