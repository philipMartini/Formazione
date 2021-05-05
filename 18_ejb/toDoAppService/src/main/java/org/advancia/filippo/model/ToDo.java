package org.advancia.filippo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;





@Entity
@Table(name = "TODO")				//Si puo notare che in JPQL è tutta notazione sulle entity non c'è traccia di nomi di colonne
@NamedQueries(
		{@NamedQuery(name = "ToDo.byUserId", query = "SELECT t FROM ToDo t where t.user.id = :id"),
		@NamedQuery(name="ToDo.byId", query="SELECT t FROM ToDo t WHERE t.id = :tid")})//In alternativa potevo passare l'intero user
@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)
public class ToDo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	
	private String text;
	
	private boolean done;
	
	@ManyToOne//() //Questo mi serve se voglio inserire un ToDo settando l'utente
	@JoinColumn(name = "user_id")
	
	//@XmlTransient
	private User user;
	
	@Transient
	private List<MyLink> links;
	
	
	


	public ToDo(int id, String title, String text) {
		super();
		this.id = id;
		this.title = title;
		this.text = text;
		this.done = false;
		this.links = new ArrayList<>();
	}


	public ToDo() {
		super();
		this.links = new ArrayList<>();
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

	@XmlTransient
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
	
	public List<MyLink> getLinks() {
		return links;
	}


	public void setLinks(List<MyLink> links) {
		this.links = links;
	}
	
	public void addLink(String uri, String rel) {
		MyLink link = new MyLink();
		link.setLink(uri);
		link.setRel(rel);
		this.links.add(link);
	}
	
	public void clearLinks() {
		this.links.clear();
	}
}
