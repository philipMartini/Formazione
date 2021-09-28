package udemy.filippo.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import udemy.filippo.entity.ToDo;
import udemy.filippo.service.ToDoService;

@Path("todos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ToDoRest {
	
	@Inject
	ToDoService toDoService;
	
	
	@GET
	public List<ToDo> getToDos(){
		return this.toDoService.getToDos();
	}
	
	
	@POST
	public Response createToDo(ToDo toDo) {
		this.toDoService.createToDo(toDo);
		return Response.ok(toDo).build();
	}
	
	@PUT
	public Response updateToDo(ToDo toDo) {
		this.toDoService.updateToDo(toDo);
		return Response.ok(toDo).build();
	}
	
	@Path("{id}")
	@GET
	public ToDo getToDo(@PathParam("id") Long id) {
		return this.toDoService.findToDoById(id);
	}
	
	
	@Path("status")
	@POST
	public Response markAsComplete(@QueryParam("id") Long id) {
		ToDo toDo = this.toDoService.findToDoById(id);
		toDo.setCompleted(true);
		this.toDoService.updateToDo(toDo);
		return Response.ok(toDo).build();
	}
	
	
	
}
