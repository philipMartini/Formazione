package org.advancia.filippo.messenger.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.advancia.filippo.messenger.model.Message;
import org.advancia.filippo.messenger.resources.beans.MessageFilterBean;
import org.advancia.filippo.messenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	MessageService messageService = new MessageService();
	
	//A seconda dell'accept header nella request viene chiamato uno dei due metodi
	//Piu precisamente esiste questa relazione Accepts <=> @Produces   Content-Type <=> @COnsumes
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getJsonMessages(@BeanParam MessageFilterBean filter){
		System.out.println("JSON Method Called");
		if(filter.getYear() > 0)
			return this.messageService.getAllMessagesForYear(filter.getYear());
		if(filter.getStart() >= 0 && filter.getSize() > 0)
			return this.messageService.getAllMessagesPaginated(filter.getStart(), filter.getSize());
		return this.messageService.getAllMessages();
	}
	
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Message> getXmlMessages(@BeanParam MessageFilterBean filter){
		System.out.println("Xml Method Called!");
		if(filter.getYear() > 0)
			return this.messageService.getAllMessagesForYear(filter.getYear());
		if(filter.getStart() >= 0 && filter.getSize() > 0)
			return this.messageService.getAllMessagesPaginated(filter.getStart(), filter.getSize());
		return this.messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	
	//La conversione la fa Jersey in modo automatico
	public Message getMessage(@PathParam("messageId") long messageId, @Context UriInfo uriInfo) {
		Message message = this.messageService.getMessage(messageId);
		
		message.addLink(getUriForSelf(uriInfo, message), "self");
		message.addLink(getUriForProfile(uriInfo, message), "profile");
		message.addLink(this.getUriForComments(uriInfo, message), "comments");
		return message;
	}

	private String getUriForComments(UriInfo uriInfo, Message message) {
		String uri = uriInfo.getBaseUriBuilder()
				.path(MessageResource.class)
				.path(MessageResource.class, "getCommentResource") // Questo mi permette di accere al path al metodo getCommentResource
				.resolveTemplate("messageId", message.getId()) //Cosi sostituiamo la variabile messageId nel path
				.build()
				.toString();
		return uri;
	}

	private String getUriForProfile(UriInfo uriInfo, Message message) {
		String uri = uriInfo.getBaseUriBuilder()
				.path(ProfileResource.class)
				.path(message.getAuthor())
				.build()
				.toString();
		return uri;
	}

	private String getUriForSelf(UriInfo uriInfo, Message message) {
		String uri = uriInfo.getBaseUriBuilder()
						.path(MessageResource.class)
						.path(Long.toString(message.getId()))
						.build()
						.toString();
		return uri;
	}
	
	
	@POST
	//Jersey converte in automatico il contenuto nella request body
	public Response addMessage(Message message, @Context UriInfo uriInfo) {
		//Aggiungiamo location header e status 201 CREATED
		System.out.println(message);
		Message newMessage = this.messageService.addMessage(message);
		URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(message.getId())).build();
		return Response.created(uri)
				.entity(newMessage)
				.build();
		
	}
	
	
	@PUT
	@Path("/{messageId}")
	
	
	public Message updateMessage(@PathParam("messageId") long messageId, Message message) {
		message.setId(messageId); 
		return this.messageService.updateMessage(message);
	}
	
	
	@DELETE
	@Path("/{messageId}")
	
	public void deleteMessage(@PathParam("messageId") long messageId) {
		this.messageService.removeMessage(messageId);
	}
	
	//In questo modo deleghiamo la gestione alla subRes CommentResource
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}
}
