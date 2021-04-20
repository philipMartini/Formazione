package org.advancia.filippo.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
@NamedQueries({
	@NamedQuery(name = "User.byNameAndPass", query = "from User where userName = :name and password = :pass"),
	@NamedQuery(name = "User.byName", query = "from User where userName = :name")
})
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String userName;
	private String password;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user") //Con mapped by 
	//Si evita la creazione di un'ulteriore tabella ma viene usato il dato membro user di ToDo come FK
	private Collection<ToDo> toDos;
	
	public User() {
		super();
		this.toDos = new ArrayList<>();
	}

	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
		this.toDos = new ArrayList<>();
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

	public void setToDos(List<ToDo> toDos) {
		this.toDos = toDos;
	}

	public void setTodosUser() {
		for(ToDo t : this.toDos)
			t.setUser(this);
		
	}
	
	
	
	
	
	

}
