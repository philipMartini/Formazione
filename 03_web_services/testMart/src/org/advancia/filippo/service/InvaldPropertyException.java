package org.advancia.filippo.service;

public class InvaldPropertyException extends Exception {
	
	private String errorDetails;

	public InvaldPropertyException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvaldPropertyException(String message, String errorDetails) {
		super(message);
		this.errorDetails = errorDetails;
		// TODO Auto-generated constructor stub
	}
	
	public String getFaultInfo(){
		return this.errorDetails;
	}
}
