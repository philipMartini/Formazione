package org.advancia.filippo.restService;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.StringTokenizer;

import javax.annotation.ManagedBean;
import javax.ejb.Stateless;
import javax.ejb.embeddable.EJBContainer;
import javax.inject.Inject;
import javax.naming.Binding;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

import org.advancia.filippo.business.UserFacadeBeanLocal;
import org.advancia.filippo.data.util.DataOperations;
import org.advancia.filippo.model.User;







//Autenticazione tramite BASIC_Auth

//@Provider
//@Stateless
public class AuthenticationFilter implements ContainerRequestFilter {
	
	private static final String AUTHORIZATION_HEADER = "Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";
	private static final String SECURED_URL_PREFIX = "todos";
	
	/*@Inject
	UserFacadeBeanLocal businessService;*/
	
	

	
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		
		System.out.println(requestContext.getUriInfo().getPath());
		
		
		
		
		if(requestContext.getUriInfo().getPath().contains(SECURED_URL_PREFIX)) {
			List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER);
			if(authHeader.size() > 0) {
				String authToken = authHeader.get(0);
				authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
				String decodedString = new String(Base64.getDecoder().decode(authToken));
				System.out.println(decodedString);
				StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
				String username = tokenizer.nextToken();
				String password = tokenizer.nextToken();
				//DataOperations.userLogin(username, password);
				
				/*Qui fai l'autenticazione*/
				//User user = this.businessService.getUserByIdAndPassword(username, password);
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

}
