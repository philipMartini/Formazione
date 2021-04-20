package org.advancia.filippo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



@Entity
@Table(name = "TODO")
@NamedQuery(name = "ToDo.byUserId", query = "from ToDo where user_id = :id")
public class ToDo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String title;
	
	private String text;
	
	private boolean done;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	
	public ToDo(int id, String title, String text) {
		super();
		this.id = id;
		this.title = title;
		this.text = text;
		this.done = false;
	}


	public ToDo() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public boolean isDone() {
		return done;
	}


	public void setDone(boolean done) {
		this.done = done;
	}
	
	
	
	
	
	

}
