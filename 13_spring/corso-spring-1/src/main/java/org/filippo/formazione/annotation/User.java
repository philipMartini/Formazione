package org.filippo.formazione.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//Questo bean è stato configurato nella classe AppConfig
public class User {
	
	private Phone phone;
	
	
	public User(Phone phone) {
		super();
		this.phone = phone;
	}


	public String getUserInfo() {
		return "Filippo Martini " + this.phone.getPhone();
	}


	//Invoca questo metodo appena hai costruito il bean
	@PostConstruct
	public void init() {
		System.out.println("Inside init!");
	}
	
	//Invoca questo metodo prima di distruggere il bean
	@PreDestroy
	public void destroy() {
		System.out.println("Inside destroy!");
	}
}
