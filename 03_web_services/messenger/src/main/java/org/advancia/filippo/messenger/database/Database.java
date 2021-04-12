package org.advancia.filippo.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.advancia.filippo.messenger.model.Message;
import org.advancia.filippo.messenger.model.Profile;

public class Database {
	
	private static Map<Long, Message> messages;
	private static Map<String, Profile> profiles;
	
	
	static {
		Database.messages = new HashMap<Long, Message>();
		Database.profiles = new HashMap<String, Profile>();
		Database.messages.put(1L, new Message(1L, "Hello World!", "John Doe"));
		Database.messages.put(2L, new Message(2L, "Hello Jersey", "Foo Bar"));
		Database.profiles.put("FOOBAR", new Profile(1l, "FOOBAR", "Foo", "Bar"));
		Database.profiles.put("JONDOE", new Profile(2l, "JONDOE", "John", "Doe"));
	}
	
	
	public static Map<Long, Message> getMessages(){
		return Database.messages;
	}
	
	
	public static Map<String, Profile> getProfiles(){
		return Database.profiles;
	}
}
