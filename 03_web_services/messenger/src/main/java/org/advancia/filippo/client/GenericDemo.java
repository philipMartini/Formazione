package org.advancia.filippo.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.advancia.filippo.messenger.model.Message;

public class GenericDemo {

	public static void main(String[] args) {
		//Get a client object
				Client client = ClientBuilder.newClient();
						
				//Fai una chiamata al base URI target
		List<Message> result=		client.target("http://localhost:8080/messenger/webapi/")
						.path("messages")
						.queryParam("year", 2021)
						.request(MediaType.APPLICATION_JSON)
						.get(new GenericType<List<Message>>() {}); //Come faccio a fare unmarshalling della lista?
		
		System.out.println(result);
	}

}
