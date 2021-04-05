package org.advancia.filippo.model;

public class ToDoBean {
	
	private int id;
	private String title;
	private String text;

	public ToDoBean() {
		// TODO Auto-generated constructor stub
	}

	public ToDoBean(String title, String text) {
		super();
		this.title = title;
		this.text = text;
	}

	public ToDoBean(int id, String title, String text) {
		super();
		this.id = id;
		this.title = title;
		this.text = text;
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
	
	public int getId() {
		return this.id;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ToDoBean other = (ToDoBean) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ToDoBean [id=" + id + ", title=" + title + ", text=" + text + "]";
	}

	
	

}
