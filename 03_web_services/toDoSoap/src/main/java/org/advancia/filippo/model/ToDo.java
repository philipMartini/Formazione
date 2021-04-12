package org.advancia.filippo.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ToDo")
public class ToDo {
	
	private int id;
	private String title;
	private String text;
	
	
	public ToDo() {}
	
	public ToDo(int id, String title, String text) {
		super();
		this.id = id;
		this.title = title;
		this.text = text;
	}
	
	
	
	@XmlElement(name = "ToDoID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@XmlElement(name = "ToDoTITLE")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	@XmlElement(name = "ToDoText")
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
	
	
	
	

}
