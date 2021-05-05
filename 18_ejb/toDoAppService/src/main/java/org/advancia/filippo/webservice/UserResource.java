package org.advancia.filippo.webservice;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.advancia.filippo.business.UserFacadeBeanLocal;
import org.advancia.filippo.model.User;

@Path("users")
@Stateless
public class UserResource {

	
	 @EJB 
	 UserFacadeBeanLocal businessService;
	 
	
	
	  @GET
	  //@Path("users")
	  @Produces(MediaType.APPLICATION_JSON)
	  //@Produces(MediaType.TEXT_XML)
	  public List<User> getUsers(@Context UriInfo uriInfo) { 
		  System.out.println("Request received");
		  List<User> users = (List<User>) this.businessService.getAllUsers();
		  for(User user : users ) {
			  this.buildLinksForUser(uriInfo, user);
		  }
	  
		  return users; 
		  }
	  
	  
	  @GET
	  @Path("{userId}")
	  @Produces(MediaType.APPLICATION_JSON) public User
	  getUser(@PathParam("userId") int id, @Context UriInfo uriInfo) {
		  System.out.println("Request received"); //Vanno gestitti i casi in cui l'utente non sia presente
		  
		  User user = this.businessService.getUserById(id);
		  buildLinksForUser(uriInfo, user);
		  
		  return user; 
	  }


	  
	  
	  @POST
	  //@Path("users")
	  @Consumes(MediaType.APPLICATION_JSON)
	  @Produces(MediaType.APPLICATION_JSON) public User addUser(User user) {
	  System.out.println("REQ received"); this.businessService.addUser(user);
	  return user; }
	  
	  @DELETE
	  @Path("{userId}")
	  @Produces(MediaType.APPLICATION_JSON) public Response
	  deleteUser(@PathParam("userId") int id) {
	  this.businessService.deleteUserById(id); return Response.noContent().build();
	  }
	  
	  
	  
	  /*Questo è il modo corretto per indirizzare alla sub-resource ma non riesco a
	  fare injection di Ejb quindi lo passo al costruttore della risorsa*/
	  
	  @Path("{userId}/todos") 
	  public ToDoResource getToDoResource() {
	  System.out.println("REQ RECEIVED"); 
	  	return new ToDoResource(this.businessService); 
	  //return new ToDoResource(); 
	  }
	  
	  /*@GET
	  @Produces(MediaType.APPLICATION_JSON)
	  @Path("users/{userId}/todos") 
	  public List<ToDo> getToDosOfUser(@PathParam("userId") int id) {
	  System.out.println("request received " + id); 
	  return (List<ToDo>) this.businessService.getToDosByUserId(id); 
	  }*/
	 
	  private void buildLinksForUser(UriInfo uriInfo, User user) {
			user.clearLinks();
			  user.addLink(this.getUriForSelf(uriInfo, user), "self");
			  user.addLink(this.getUriForToDos(uriInfo, user), "todos");
		}
	  
	  
	  private String getUriForSelf(UriInfo uriInfo, User user) {
		  String uri = uriInfo.getBaseUriBuilder()
					.path(UserResource.class)
					.path(Long.toString(user.getId()))
					.build()
					.toString();
		  return uri;
	  }
	  
	  private String getUriForToDos(UriInfo uriInfo, User user) {
		  String uri = uriInfo.getBaseUriBuilder()
				  	.path(UserResource.class)
				  	.path(UserResource.class, "getToDoResource")
				  	.resolveTemplate("userId", user.getId())
				  	.build()
				  	.toString();
		  return uri;
	  }
}
