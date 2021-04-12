package org.advancia.filippo.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.advancia.filippo.messenger.model.ErrorMessage;

//Questa annotazione la registra per JAXRS
@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException exception) {
		// TODO Auto-generated method stub
		ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), 404, "/gitPages");
		return Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
	}

	

}
