package org.advancia.filippo.messenger.service;

import java.util.ArrayList;
import java.util.List;

import org.advancia.filippo.messenger.model.Message;

public class MessageService {
	
	private List<Message> messages;
	
	public List<Message> getAllMessages(){
		Message m1 = new Message(1L, "Hello World", "john");
		Message m2 = new Message(2l, "Hello Jersey", "doe");
		this.messages = new ArrayList<Message>();
		this.messages.add(m1);
		this.messages.add(m2);
		return this.messages;
	}

}
