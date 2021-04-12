package org.advancia.filippo.toDoRest.buisness;

import java.util.List;

import org.advancia.filippo.toDoRest.exceptions.ToDoException;
import org.advancia.filippo.toDoRest.database.Database;
import org.advancia.filippo.toDoRest.model.ToDo;

public class ToDosOperations {
	
	private List<ToDo> toDos;
	
	
	
	public ToDosOperations() {
		this.toDos = Database.getToDos();
	}
	
	
	public List<ToDo> getToDos(){
		return this.toDos;
	}
	
	public ToDo getToDo(int id) {
		for(ToDo t : this.toDos) {
			if(t.getId() == id)
				return t;
		}
		
		return null;
	}
	
	
	public ToDo addToDo(ToDo toDo) {

		return this.addToDo(toDo.getTitle(), toDo.getText()); 
	}
	
	public ToDo addToDo(String text, String title) {
		int newId = this.toDos.get(this.toDos.size() -1).getId() + 1;
		ToDo toDo = new ToDo(newId, text, title);
		this.toDos.add(toDo);
		Database.add(toDo);
		return toDo;
	}
	
	public void deleteToDo(int id) throws ToDoException {
		for(ToDo t : this.toDos) {
			if(t.getId() == id) {
				this.toDos.remove(t);
				Database.remove(t.getId());
				return;
			}
		}
		
		throw new ToDoException("ToDo with ID " + id + " NOT FOUND CANNOT REMOVE IT!");
	}


	public ToDo updateToDo(int id, String updateTitle, String updateText) throws ToDoException {
		for(ToDo t : this.toDos) {
			if(t.getId() == id) {
				t.setText(updateText);
				t.setTitle(updateTitle);
				Database.add(t);
				return t;
			}
		}
		throw new ToDoException("ToDo with ID " + id + " NOT FOUND CANNOT UPDATE IT!");
	}

}
