package org.advancia.filippo.publisher;

import javax.xml.ws.Endpoint;

import org.advancia.filippo.service.ToDoService;


public class Application {
	
	
	
	public static void main(String[] args) {
		final String url  = "http://localhost:7777/ws";
		System.out.println("Publishing service at " + url);
		Endpoint.publish(url, new ToDoService());
	}
	
}
