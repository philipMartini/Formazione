package org.advancia.filippo.buisness;

import java.util.List;

import org.advancia.filippo.data.Database;
import org.advancia.filippo.exceptions.ToDoException;
import org.advancia.filippo.model.ToDo;

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
		
		this.addToDo(toDo.getTitle(), toDo.getText());
		//Database.add(toDo);
		return toDo;
	}
	
	public ToDo addToDo(String text, String title) {
		int newId = this.toDos.get(this.toDos.size() -1).getId() + 1;
		ToDo toDo = new ToDo(newId, text, title);
		this.toDos.add(toDo);
		return toDo;
	}
	
	public void deleteToDo(int id) throws ToDoException {
		for(ToDo t : this.toDos) {
			if(t.getId() == id) {
				this.toDos.remove(t);
				return;
			}
		}
		
		throw new ToDoException("ToDo with ID " + id + " NOT FOUND CANNOT REMOVE IT!", "Invalid Remove OPS");
	}


	public ToDo updateToDo(int id, String updateTitle, String updateText) throws ToDoException {
		for(ToDo t : this.toDos) {
			if(t.getId() == id) {
				t.setText(updateText);
				t.setTitle(updateTitle);
				return t;
			}
		}
		throw new ToDoException("ToDo with ID " + id + " NOT FOUND CANNOT UPDATE IT!", "Invalid Update OPS");
	}

}
