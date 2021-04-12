package org.advancia.filippo.rest;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("test")
@Singleton // QUesta annotazione modifica lo scope della risorsa e passa nello scope di Contesto
public class MyResource {
	//OGNI RICHIESTA PRODUCE UNA NUOVA ISTANZA DI MYRESOURCE QUINDI VIENE STAMPATO SEMPRE 1
	//iN MODO PIÙ ELEGANTE LO SCOPE di default DELLE RISORSE È REQUEST
	private int count;
		
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testMethod() {
		++count;
		return "It Works " + count + " count(s)";
	}
}
