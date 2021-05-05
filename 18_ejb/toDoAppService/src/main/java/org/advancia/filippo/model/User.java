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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

//import org.codehaus.jackson.annotate.JsonIgnore;

//import com.fasterxml.jackson.annotation.JsonIgnore;

//import org.codehaus.jackson.annotate.JsonIgnore;






@Entity
@Table(name = "USER")
@NamedQueries({
	@NamedQuery(name = "User.byNameAndPass", query = "SELECT u from User u  where u.userName = :name and u.password = :pass"),
	@NamedQuery(name = "User.byName", query = "SELECT u from User u where u.userName = :name"),
	@NamedQuery(name = "User.allUsers", query = "SELECT u FROM User u"),
	@NamedQuery(name= "User.byId", query = "SELECT u FROM User u where u.id = :user_id")
})
@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String userName;
	private String password;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user") //Con mapped by 
	//Si evita la creazione di un'ulteriore tabella "user" è il dato membro in ToDo per l'associazione inversa
	//Cioe ManyToOne
	//La restApi non restituisce i todos ma verranno linkati con la HATEOAS
	//@XmlTransient
	//@JsonIgnore
	private Collection<ToDo> toDos;
	
	@Transient
	private List<MyLink> links;
	
	

	public User() {
		super();
		this.toDos = new ArrayList<>();
		this.links = new ArrayList<>();
	}

	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
		this.toDos = new ArrayList<>();
		this.links = new ArrayList<>();
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
	
	@XmlTransient //Usando Jackson e non Moxy questo va bene sia per Json che per Xml
	public Collection<ToDo> getToDos() {
		return toDos;
	}
	
	//@XmlTransient
	public void setToDos(List<ToDo> toDos) {
		this.toDos = toDos;
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
	
	public void setTodosUser() {
		for(ToDo t : this.toDos)
			t.setUser(this);
		
	}
	
	
	
	
}
