package org.advancia.filippo.toDoRest.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.advancia.filippo.toDoRest.model.ErrorMessage;

//Questa annotazione la registra per JAXRS
@Provider
public class ToDoExceptionMapper implements ExceptionMapper<ToDoException> {

	@Override
	public Response toResponse(ToDoException exception) {
		ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), 500, "/gitPages");
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(errorMessage)
				.build();
	}

}
