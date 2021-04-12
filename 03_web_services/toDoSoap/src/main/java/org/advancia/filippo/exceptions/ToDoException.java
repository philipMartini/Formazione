package org.advancia.filippo.exceptions;

public class ToDoException extends Exception {
	
	private String errorDetails;
	
	public ToDoException() {
		super();
	}
	
	public ToDoException(String message, String errorDetails) {
		super(message);
		this.errorDetails = errorDetails;
	}
	
	public String getFaultInfo() {
		return this.errorDetails;
	}
	
}
