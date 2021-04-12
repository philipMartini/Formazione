package org.advancia.filippo.service;

import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import org.advancia.filippo.buisness.ToDosOperations;
import org.advancia.filippo.exceptions.ToDoException;
import org.advancia.filippo.model.ToDo;

@WebService(endpointInterface = "org.advancia.filippo.service.IToDoService", 
				serviceName = "ToDosService", portName = "ToDosServicePort")

public class ToDoService implements IToDoService{
	
	private ToDosOperations toDoOps = new ToDosOperations();

	@Override
	public List<ToDo> getToDos() {
		
		return this.toDoOps.getToDos();
	}

	@Override
	public ToDo getToDo(int id) {
		return this.toDoOps.getToDo(id);
	}

	@Override
	public ToDo addToDo(ToDo toDo) {
		return this.toDoOps.addToDo(toDo);
	}

	@Override
	public void deleteToDo(int id) throws ToDoException {
		this.toDoOps.deleteToDo(id);
		
	}

	@Override
	public ToDo updateToDo(int id, String updateTitle, String updateText) throws ToDoException {
		return this.toDoOps.updateToDo(id, updateTitle, updateText);
	}

	

}
