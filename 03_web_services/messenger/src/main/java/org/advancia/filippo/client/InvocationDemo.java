package org.advancia.filippo.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class InvocationDemo {
	
	public static void main(String[] args) {
		
		Invocation invocation = InvocationDemo.prepareRequestForMessageByYear(2021);
		Response response = invocation.invoke();
		System.out.println(response.getStatus());
		
		
	}

	public static Invocation prepareRequestForMessageByYear(int year) {
		//Get a client object
		Client client = ClientBuilder.newClient();
				
		//Fai una chiamata al base URI target
		return client.target("http://localhost:8080/messenger/webapi/")
				.path("messages")
				.queryParam("year", year)
				.request(MediaType.APPLICATION_JSON)
				.buildGet();
	}
	
	
}
