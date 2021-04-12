package org.advancia.filippo.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.advancia.filippo.messenger.model.Message;

public class RestApiClient {

	public static void main(String[] args) {
		//Get a client object
		Client client = ClientBuilder.newClient();
		
		//Fai una chiamata al base URI target
		WebTarget baseTarget = client.target("http://localhost:8080/messenger/webapi/");
		//Target per tutte le interazioni con i messaggi
		WebTarget messagesTarget = baseTarget.path("messages");
		WebTarget singleMessageTarget = messagesTarget.path("{messageId}");
		
		//Sostituisci 2 a messageId
		//Buildo la request in questo caso setto accept header 
		Builder builder = singleMessageTarget.resolveTemplate("messageId", 2).request(MediaType.APPLICATION_JSON);
		//Chiamo http get sul builder dicendo che mi aspetto nel body della response un Message
		Message message = builder.get(Message.class);
				
		//Message message = response.readEntity(Message.class);
		System.out.println(message.getMessage());
		
		//POST REQ
		Message newMessage = new Message(4, "My New Message From The client", "Filippo");
		Response postResponse = messagesTarget
										.request()
										.post(Entity.json(newMessage));
		
		if(postResponse.getStatus() != 201)
			System.out.println("CREATION ERROR");
		else
			System.out.println(postResponse.readEntity(Message.class));
		
		
	}

}
