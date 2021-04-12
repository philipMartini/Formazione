package org.advancia.filippo.toDoRest.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.advancia.filippo.toDoRest.model.MyLink;


@XmlRootElement
public class ToDo {
	
	private int id;
	private String title;
	private String text;
	private List<MyLink> links;
	
	
	public ToDo() { this.links = new ArrayList<>(); }
	
	public ToDo(int id, String title, String text) {
		super();
		this.id = id;
		this.title = title;
		this.text = text;
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

	public List<MyLink> getLinks() {
		return links;
	}
	
	public void setLinks(List<MyLink> links) {
		this.links = links;
	}
	
	public void addLink(String rel, String link) {
		MyLink actualLink = new MyLink();
		actualLink.setRel(rel);
		actualLink.setLink(link);
		this.links.add(actualLink);
	}

	public void clearLinks() {
		this.links.clear();
		
	}

	@Override
	public String toString() {
		return "ToDo [id=" + id + ", title=" + title + ", text=" + text + ", links=" + links + "]";
	}

	
	
	
	

}
