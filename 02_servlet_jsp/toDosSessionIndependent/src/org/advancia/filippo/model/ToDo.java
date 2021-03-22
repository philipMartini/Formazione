package org.advancia.filippo.model;

import java.util.UUID;

import org.advancia.filippo.controller.InvalidToDoException;

public class ToDo {
	
	private String title;
	private String text;
	private final UUID uuid;

	public ToDo() { this.uuid = UUID.randomUUID();}
	
	
	public ToDo(String title, String text) throws InvalidToDoException {
		super();
		this.setTitle(title);
		this.text = text;
		this.uuid = UUID.randomUUID();
	}


	public String getTitle() {
		return title;
	}


	public String getText() {
		return text;
	}


	public UUID getUuid() {
		return uuid;
	}
	
	public String getStringUuId(){ return this.uuid.toString().replace("-", ""); }


	public void setTitle(String title) throws InvalidToDoException {
		if("".equals(title))
			throw new InvalidToDoException("Title Cannot Be Empty!");
		this.title = title;
	}


	public void setText(String text) {
		this.text = text;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
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
		ToDo other = (ToDo) obj;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ToDo [title=" + title + ", text=" + text + ", uuid=" + uuid + "]";
	}
	
	
	
}
