package org.advancia.filippo.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.advancia.filippo.model.ToDo;

public class Database {
	
	private static Map<Integer, ToDo> db;
	
	static {
		db = new HashMap<>();
		db.put(1, new ToDo(1, "First Title", "First Text"));
		db.put(2, new ToDo(2, "Second Title", "Second Text"));
	}
	
	public static List<ToDo> getToDos() { return new ArrayList<>(db.values());}

	public static void add(ToDo toDo) {
		db.put(toDo.getId(), toDo);
		
	}
	

}
