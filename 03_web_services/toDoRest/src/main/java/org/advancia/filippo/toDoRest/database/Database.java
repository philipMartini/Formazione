package org.advancia.filippo.toDoRest.database;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.advancia.filippo.toDoRest.model.ToDo;

public class Database {
	
	private static Map<Integer, ToDo> db;
	
	static {
		db = new HashMap<>();
		db.put(1, new ToDo(1, "First Title", "First Text"));
		db.put(2, new ToDo(2, "Second Title", "Second Text"));
	}
	
	public static List<ToDo> getToDos() { 
		return new ArrayList<>(db.values());}

	public static void add(ToDo toDo) {
		db.put(toDo.getId(), toDo);
		
	}

	public static void remove(int id) {
		db.remove(id);
		
	}
	

}
