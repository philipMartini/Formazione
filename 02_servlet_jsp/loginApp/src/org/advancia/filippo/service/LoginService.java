package org.advancia.filippo.service;

import java.util.HashMap;
import java.util.Map;

import org.advancia.filippo.dto.User;

public class LoginService {
	
	private Map<String, User> users;

	public LoginService() {
		this.users = new HashMap<>();
		this.users.put("johnDoe", new User("johnDoe","John Doe"));
		this.users.put("fooBar", new User("fooBar","Foo Bar"));
		this.users.put("killaCam", new User("killaCam","Killa Cam"));
	}
	
	public boolean authenticate(String userId, String password){
		if(password != null && !"".equals(password.trim()))
			return true;
		return false;
	}
	
	public User getUserDetails(String userId){
		return this.users.get(userId);
	}

}
