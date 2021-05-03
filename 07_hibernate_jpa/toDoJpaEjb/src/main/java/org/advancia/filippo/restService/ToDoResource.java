package org.advancia.filippo.restService;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.advancia.filippo.business.ToDoFacadeLocal;
import org.advancia.filippo.business.UserFacadeBeanLocal;
import org.advancia.filippo.model.ToDo;

@Path("/")
@Stateless
public class ToDoResource {
	
	@EJB
	ToDoFacadeLocal service;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ToDo> getToDosOfUser(@PathParam("userId") int id) {
		System.out.println("request received " + id);
		return (List<ToDo>) this.service.getToDosByUserId(id);
	}

}
