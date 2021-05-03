package org.advancia.filippo.restService;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.advancia.filippo.business.UserFacadeBeanLocal;
import org.advancia.filippo.model.ToDo;
import org.advancia.filippo.model.User;

@Path("webapi")
@Stateless
public class UserResource {

	
	 @EJB UserFacadeBeanLocal businessService;
	 
	
	
	  @GET
	  @Path("users")
	  @Produces(MediaType.APPLICATION_JSON)
	  public List<User> getUsers() { 
		  System.out.println("Request received");
		  List<User> users = (List<User>) this.businessService.getAllUsers();
	  
		  return users; 
		  }
	  
	  @GET
	  
	  @Path("users/{userId}")
	  
	  @Produces(MediaType.APPLICATION_JSON) public User
	  getUser(@PathParam("userId") int id) {
		  System.out.println("Request received"); //Vanno gestitti i casi in cui l'utente non sia presente 
		  User user = this.businessService.getUserById(id);
		  
		  return user; 
	  }
	  
	  
	  @POST
	  @Path("users")
	  @Consumes(MediaType.APPLICATION_JSON)
	  @Produces(MediaType.APPLICATION_JSON) public User addUser(User user) {
	  System.out.println("REQ received"); this.businessService.addUser(user);
	  return user; }
	  
	  @DELETE
	  
	  @Path("users/{userId}")
	  
	  @Produces(MediaType.APPLICATION_JSON) public Response
	  deleteUser(@PathParam("userId") int id) {
	  this.businessService.deleteUserById(id); return Response.noContent().build();
	  }
	  
	  
	  
	  /*Questo è il modo corretto per indirizzare alla sub-resource ma non riesco a
	  fare injection di Ejb*/
	  
	  @Path("users/{userId}/todos") 
	  public ToDoResource getToDoResource() {
	  System.out.println("REQ RECEIVED"); 
	  return new ToDoResource(); 
	  }
	  
	  /*@GET
	  @Produces(MediaType.APPLICATION_JSON)
	  @Path("users/{userId}/todos") 
	  public List<ToDo> getToDosOfUser(@PathParam("userId") int id) {
	  System.out.println("request received " + id); 
	  return (List<ToDo>) this.businessService.getToDosByUserId(id); 
	  }*/
	 

}
