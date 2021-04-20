package org.advancia.filippo.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


public class User {
	
	
	private int id;
	private String userName;
	private String password;
	
	private Collection<ToDo> toDos;
	
	public User() {
		super();
		this.toDos = new HashSet<>();
	}

	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
		this.toDos = new HashSet<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<ToDo> getToDos() {
		return toDos;
	}

	public void setToDos(Collection<ToDo> toDos) {
		this.toDos = toDos;
	}

	public void setTodosUser() {
		for(ToDo t : this.toDos)
			t.setUser(this);
		
	}
	
	
	
	
	
	

}
