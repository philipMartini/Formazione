package org.advancia.filippo.webservice;


import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.StringTokenizer;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.advancia.filippo.business.UserFacadeBeanLocal;
import org.advancia.filippo.model.User;





//Autenticazione tramite BASIC_Auth

//@Provider
@Stateless
public class AuthenticationFilter implements ContainerRequestFilter {
	
	private static final String AUTHORIZATION_HEADER = "Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";
	private static final String SECURED_URL_PREFIX = "todos";
	
	@EJB
	UserFacadeBeanLocal service;
	
	

	
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		
		System.out.println(requestContext.getUriInfo().getPath());
		
		
		
		
		if(requestContext.getUriInfo().getPath().contains(SECURED_URL_PREFIX)) {
			List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER);
			if(authHeader != null && authHeader.size() > 0) {
				String authToken = authHeader.get(0);
				authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
				String decodedString = new String(Base64.getDecoder().decode(authToken));
				System.out.println(decodedString);
				StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
				String username = tokenizer.nextToken();
				String password = tokenizer.nextToken();
				
				
				/*Qui fai l'autenticazione*/
				User user = service.getUserByIdAndPassword(username, password);
				if(user != null) {
					System.out.println("User Authenticated !!!" + user);
					return;
				}
			}
			
			Response unauthorizedStatus = Response
										.status(Response.Status.UNAUTHORIZED)
										.entity("User cannot access the resource")
										.build();
			requestContext.abortWith(unauthorizedStatus);
		}
	}

}