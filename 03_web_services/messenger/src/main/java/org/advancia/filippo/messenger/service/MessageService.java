package org.advancia.filippo.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.advancia.filippo.messenger.database.Database;
import org.advancia.filippo.messenger.exception.DataNotFoundException;
import org.advancia.filippo.messenger.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages;
	
	
	public MessageService() {
		this.messages = Database.getMessages();
		
	}
	
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(this.messages.values());
	}
	
	
	public List<Message> getAllMessagesForYear(int year){
		List<Message> messages = new ArrayList<Message>();
		Calendar cal = Calendar.getInstance();
		for(Message m : this.messages.values()) {
			cal.setTime(m.getCreated());
			if(cal.get(Calendar.YEAR) == year) {
				messages.add(m);
				System.out.println(m);
			}
		}
		return messages;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size){
		List<Message> messages = new ArrayList<Message>();
		return messages.subList(start, start + size);
	}
	
	public Message getMessage(long id) {
		Message message =  this.messages.get(id);
		if(message == null)
			throw new DataNotFoundException("Message with id " + id + " NOT found!");
		return message;
	}
	
	public Message addMessage(Message message) {
		message.setId(this.messages.size() + 1);
		this.messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if(message.getId() <= 0)
			return null;
		
		this.messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id) { return this.messages.remove(id); }
}
