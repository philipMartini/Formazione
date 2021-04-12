package org.advancia.filippo.toDoRest.model;

public class MyLink {
	
	private String link;
	private String rel;
	
	
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getRel() {
		return rel;
	}
	public void setRel(String rel) {
		this.rel = rel;
	}
	@Override
	public String toString() {
		return "MyLink [link=" + link + ", rel=" + rel + "]";
	}
	
	
	

}
