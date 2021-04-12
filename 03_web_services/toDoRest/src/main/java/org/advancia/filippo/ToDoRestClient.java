package org.advancia.filippo;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.advancia.filippo.toDoRest.model.ToDo;

public class ToDoRestClient {
	
	public static void main(String[] args) {
		//Get a client object
		Client client = ClientBuilder.newClient();
		
		//Fai una chiamata al base URI target
		WebTarget baseTarget = client.target("http://localhost:8080/toDoRest/webapi/");
		//Target per tutte le interazioni con i messaggi
		WebTarget toDosTarget = baseTarget.path("todos");
		WebTarget singleToDoTarget = toDosTarget.path("{toDoId}");
		
		//Sostituisci 2 a messageId
		//Buildo la request in questo caso setto accept header 
		Builder builder = singleToDoTarget.resolveTemplate("toDoId", 2).request(MediaType.APPLICATION_JSON);
		//Chiamo http get sul builder dicendo che mi aspetto nel body della response un Message
		ToDo toDo = builder.get(ToDo.class);
				
		//Message message = response.readEntity(Message.class);
		System.out.println(toDo);
		
		//POST REQ
		ToDo newMessage = new ToDo(1, "My New toDo From The client", "Text Client");
		Response postResponse = toDosTarget
										.request()
										.post(Entity.json(newMessage));
		
		if(postResponse.getStatus() != 201)
			System.out.println("CREATION ERROR");
		else
			System.out.println(postResponse.readEntity(ToDo.class));
		
		builder = toDosTarget.request(MediaType.APPLICATION_JSON);
		Response response = builder.get();
		List<ToDo> toDos = response.readEntity(new GenericType<List<ToDo>> () {});
		System.out.println("LIST SIZE IS : " + toDos.size());
		
		
	}

}
