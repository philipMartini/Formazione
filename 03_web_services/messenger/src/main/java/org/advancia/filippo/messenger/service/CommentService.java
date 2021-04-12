package org.advancia.filippo.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.advancia.filippo.messenger.database.Database;
import org.advancia.filippo.messenger.model.Comment;
import org.advancia.filippo.messenger.model.ErrorMessage;
import org.advancia.filippo.messenger.model.Message;


public class CommentService {
	
	private Map<Long, Message> messages = Database.getMessages();
	
	
	public List<Comment> getAllComments(long messageId){
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<Comment>(comments.values());
	}
	
	public Comment getComment(long messageId, long commentId) {
		//COn exceptionMApper è molto più pulito oppure.....
		ErrorMessage errorMessage = new ErrorMessage("Not Found", 404, "/DOcs");
		Response response = Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
		
		Message message =  this.messages.get(messageId);
		if(message == null)
			throw new WebApplicationException(response);
		Map<Long, Comment> comments = message.getComments();
		if(comments == null)
			throw new NotFoundException(response); //....Usare le eccezioni che estendono WebAppException
		return comments.get(commentId);
	}
	
	public Comment addComment(long messageId, Comment comment) {
		comment.setId(this.messages.get(messageId).getComments().size() + 1);
		return this.messages.get(messageId).getComments().put(comment.getId(), comment);
	}
	
	public Comment updateComment(long messageId, Comment comment) {
		return this.messages.get(messageId).getComments().put(comment.getId(), comment);
	}
	
	public Comment removeComment(long messageId, long commentId) {
		return this.messages.get(messageId).getComments().remove(commentId);
	}
}
