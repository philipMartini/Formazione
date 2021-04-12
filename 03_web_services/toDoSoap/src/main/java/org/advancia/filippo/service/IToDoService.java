package org.advancia.filippo.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import org.advancia.filippo.exceptions.ToDoException;
import org.advancia.filippo.model.ToDo;

@WebService(name = "ToDos")
@SOAPBinding(style = Style.DOCUMENT)
public interface IToDoService {
	
	@WebMethod(action = "get_todos", operationName = "GEToDos")
	@WebResult(name = "toDosList")
	List<ToDo> getToDos();
	
	@WebMethod
	@WebResult(name = "TODo")
	ToDo getToDo(@WebParam(name = "toDoId")int id);
	
	@WebMethod
	@WebResult(name = "addedToDo")
	ToDo addToDo(@WebParam(name = "toDoToAdd")ToDo toDo);
	
	@WebMethod
	void deleteToDo(@WebParam(name = "toDoId") int id) throws ToDoException;
	
	@WebMethod
	@WebResult(name = "UpdatedToDo")
	ToDo updateToDo(@WebParam(name = "toDoId")int id, 
				@WebParam(name = "updatedTitle")String updateTitle, 
				@WebParam(name = "updatedText")String updateText) throws ToDoException;

}
