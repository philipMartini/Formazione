package org.filippo.formazione;

public class BeanPrototype {
	
	private String message;
	
	
	public String hello() {
		return this.message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
