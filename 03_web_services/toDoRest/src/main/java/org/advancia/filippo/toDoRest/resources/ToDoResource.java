package org.advancia.filippo.toDoRest.resources;

import java.net.URI;
import java.util.List;

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

import org.advancia.filippo.toDoRest.buisness.ToDosOperations;
import org.advancia.filippo.toDoRest.exceptions.ToDoException;
import org.advancia.filippo.toDoRest.model.ToDo;

@Path("/todos")
public class ToDoResource {
	
	ToDosOperations ops = new ToDosOperations();
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ToDo> getToDos(@Context UriInfo uriInfo){
		List<ToDo> toDos = this.ops.getToDos();
		for(ToDo t : toDos) {
			t.clearLinks();
			t.addLink("self", this.getUriForSelf(uriInfo, t));
		}
		return toDos;
	}
	
	@GET
	@Path("/{toDoId}")
	@Produces(MediaType.APPLICATION_JSON)
	public ToDo getToDo(@Context UriInfo uriInfo, @PathParam("toDoId") int id) {
		ToDo toDo = this.ops.getToDo(id);
		toDo.clearLinks();
		toDo.addLink("self", this.getUriForSelf(uriInfo, toDo));
		return toDo;
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addToDo(ToDo toDo, @Context UriInfo uriInfo) {
		ToDo newToDo = this.ops.addToDo(toDo);
		newToDo.addLink("self", this.getUriForSelf(uriInfo, newToDo));
		URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(newToDo.getId())).build(); 
		//webestapi/toDosRest/toDos/toDoId 
		return Response.created(uri) //201 created
				.entity(newToDo) // aggiungi l'entità creata
				.build();// builda la response	
	}
	
	@DELETE
	@Path("/{toDoId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response  deleteToDo(@Context UriInfo uriInfo,@PathParam("toDoId") int id) throws ToDoException {
		this.ops.deleteToDo(id);
		return Response.noContent().build();
	}
	
	@PUT
	@Path("/{toDoId}")
	@Produces(MediaType.APPLICATION_JSON)
	public ToDo updateToDo(@Context UriInfo uriInfo,@PathParam("toDoId") int id,  ToDo updatedToDo) throws ToDoException {
		
		 return this.ops.updateToDo(id,updatedToDo.getTitle(), updatedToDo.getText());
		
	}
	
	
	//Costruisce i links per la risorsa self
	private String getUriForSelf(UriInfo uriInfo, ToDo toDo) {
		String uri = uriInfo.getBaseUriBuilder() //webapi
					.path(ToDoResource.class) //todos
					.path(Integer.toString(toDo.getId()))//toDoid
					.build()
					.toString(); 
		return uri;
	}
	
	
	
	
	

}
