package org.advancia.filippo.toDoRest.exceptions;

public class ToDoException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	
	public ToDoException() {}

	public ToDoException(String message) {
		super(message);
		
	}

}
