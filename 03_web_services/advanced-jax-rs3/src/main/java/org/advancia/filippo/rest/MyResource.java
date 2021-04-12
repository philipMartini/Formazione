package org.advancia.filippo.rest;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

//E aggiungendo @SINGLETON??????? => errore Perche la risorsa singletono viene creata PRIMA Della richiesta
//E quindi non è possibile fare injection dalle annotations

@Path("{pathParam}/test")
public class MyResource {
	
	@PathParam("pathParam") private String pathParamExample; //Annotazioni con i dati membro della classe
	@QueryParam("query") private String queryParamExample;
	//è concettualemnte equivalente a metterle nel metodo, ma puo essere utile se altri metodi devono accedere
	//A questi dati membro della classe e QUESTO VALE PER ogni ANNotazione
		
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testMethod() {
		
		return "It Works Path Params used " + this.pathParamExample + " Query Param Used: " + this.queryParamExample;
	}
}
