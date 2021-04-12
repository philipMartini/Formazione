package org.advancia.filippo.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
	
	@GET
	@Path("annotations")
	public String getParamsUsingAnnotations(@MatrixParam("param") String matrixParam,
			@HeaderParam("authSessionId") String header, @CookieParam("name") String cookie) {
		return "Matrix Param: " + matrixParam + " Header Param: " + header + " Cookie Param: " + cookie;
	}
	
	//Gli stessi parametri si possono accedere usando la context annotation e poi facendo
	//injection su due oggetti UriInfo e HttpHeaders
	@GET
	@Path("context")
	public String getParamsUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders headers) {
		String path = uriInfo.getAbsolutePath().toString();
		String cookies = headers.getCookies().toString();
		return "Path: " + path + " Cookies: " + cookies;
	}
	
	
	//Un terzo modo è usare un BeanParam che aggrega tutte le annotazioni...Vedi messageResource
}
