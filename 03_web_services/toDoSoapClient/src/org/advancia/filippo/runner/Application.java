package org.advancia.filippo.runner;

import java.util.List;

import org.advancia.filippo.service.ToDo;
import org.advancia.filippo.service.ToDoException_Exception;
import org.advancia.filippo.service.ToDos;
import org.advancia.filippo.service.ToDosService;

public class Application {

	public static void main(String[] args) {
		
		
		ToDosService toDoService = new ToDosService();
		ToDos service = toDoService.getToDosServicePort();
		
		
		List<ToDo> result = service.geToDos();
		for(ToDo t : result) {
			System.out.println(t.getToDoTITLE());
		}
		
		//Add
		ToDo toDo = new ToDo();
		toDo.setToDoID(1);
		toDo.setToDoTITLE("Third Title");
		toDo.setToDoText("Third Text");
		service.addToDo(toDo);
		
		result = service.geToDos();
		for(ToDo t : result) {
			System.out.println(t.getToDoID());
		}
		
		
		
		try {
			service.updateToDo(3, "UPDATE", "UPDATE");
		} catch (ToDoException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		result = service.geToDos();
		for(ToDo t : result) {
			System.out.println(t.getToDoTITLE());
		}
			
			
			try {
			service.deleteToDo(3);
		} catch (ToDoException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			result = service.geToDos();
			for(ToDo t : result) {
				System.out.println(t.getToDoTITLE());
			}
	}

}
