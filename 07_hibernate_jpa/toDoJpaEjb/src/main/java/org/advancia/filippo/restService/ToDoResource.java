package org.advancia.filippo.restService;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.StringTokenizer;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import org.advancia.filippo.business.UserFacadeBeanLocal;
import org.advancia.filippo.model.ToDo;
import org.advancia.filippo.model.User;

@Path("/")
@Stateless
public class ToDoResource {
	
	
	private static final String AUTHORIZATION_HEADER = "Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";
	private static final String SECURED_URL_PREFIX = "todos";
	
	
	@EJB
	UserFacadeBeanLocal service;
	
	public ToDoResource() {}
	
	public ToDoResource(UserFacadeBeanLocal service) {
		this.service = service;
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ToDo> getToDosOfUser(@Context HttpHeaders headers, @PathParam("userId") int id) {
		System.out.println("request received " + id);
		try {
			this.filter(headers);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (List<ToDo>) this.service.getToDosByUserId(id);
	}
	
	
	public void filter(HttpHeaders headers) throws IOException {
			
		
				List<String> authHeader = headers.getRequestHeaders().get(AUTHORIZATION_HEADER);
				if(authHeader.size() > 0) {
					String authToken = authHeader.get(0);
					authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
					String decodedString = new String(Base64.getDecoder().decode(authToken));
					System.out.println(decodedString);
					StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
					String username = tokenizer.nextToken();
					String password = tokenizer.nextToken();
					
					
					/*Qui fai l'autenticazione*/
					User user = this.service.getUserByIdAndPassword(username, password);
					//System.out.println("User " + user);
					return;
				}
				
				/*Response unauthorizedStatus = Response
											.status(Response.Status.UNAUTHORIZED)
											.entity("User cannot access the resource")
											.build();
				requestContext.abortWith(unauthorizedStatus);*/
			}
		
	

}
