package org.advancia.filippo.webservice;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.advancia.filippo.business.UserFacadeBeanLocal;
import org.advancia.filippo.model.ToDo;

@Path("/")
@Stateless
public class ToDoResource {
	
	@EJB 
	 UserFacadeBeanLocal service;
	
	public ToDoResource() {}
	
	public ToDoResource(UserFacadeBeanLocal service) {
		this.service = service;
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ToDo> getToDosOfUser(@PathParam("userId") int id) {
		System.out.println("request received " + id);
		return (List<ToDo>) this.service.getToDosByUserId(id);
	}
	
	@GET
	@Path("{toDoId}")
	@Produces(MediaType.APPLICATION_JSON)
	public ToDo getToDoOfUser(@Context UriInfo uriInfo, @PathParam("userId") int userId, @PathParam("toDoId") int toDoId) {
		ToDo toDo =  this.service.getToDoById(toDoId);
		this.builLinksForToDo(uriInfo, userId, toDo);
		return toDo;
	}

	private void builLinksForToDo(UriInfo uriInfo, int userId, ToDo toDo) {
		toDo.clearLinks();
		toDo.addLink(this.getUriForSelf(uriInfo, toDo, userId), "self");
		toDo.addLink(this.getUriForParentResource(uriInfo, toDo, userId), "todos");
		toDo.addLink(this.getLinkForUserResource(uriInfo, userId), "user");
	}
	
	//Nell'oggetto toDo saranno presenti tre link uno alla rel self, e uno alla rel parent cioè i todos
	//E uno all'utente
	
	private String getLinkForUserResource(UriInfo uriInfo, int userId) {
		 String uri = uriInfo.getBaseUriBuilder()
				  	.path(UserResource.class)
				  	.path(Long.toString(userId))
					.build()
					.toString();
		  return uri;
	}

	private String getUriForSelf(UriInfo uriInfo, ToDo toDo, int userId) {
		  String uri = uriInfo.getBaseUriBuilder()
				  	.path(UserResource.class)
				  	.path(Long.toString(userId))
					.path("todos")
					.path(Long.toString(toDo.getId()))
					.build()
					.toString();
		  return uri;
	  }
	
	private String getUriForParentResource(UriInfo uriInfo, ToDo toDo, int userId) {
		  String uri = uriInfo.getBaseUriBuilder()
				  	.path(UserResource.class)
				  	.path(Long.toString(userId))
					.path("todos")
					.build()
					.toString();
		  return uri;
	  }

}

