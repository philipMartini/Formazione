package org.advancia.filippo.rest;


import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Path("test")
public class MyResource {

		
	@GET
	//Creazione custom mediatype
	//Verrà utilizzato quello segnalato dal client tramtite lheader accept
	@Produces(value= {MediaType.TEXT_PLAIN, "text/shortdate"})
	public Date testMethod() {
		
		return Calendar.getInstance().getTime();
	}
}
