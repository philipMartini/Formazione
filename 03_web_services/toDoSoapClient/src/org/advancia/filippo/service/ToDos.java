
package org.advancia.filippo.service;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ToDos", targetNamespace = "http://service.filippo.advancia.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ToDos {


    /**
     * 
     * @return
     *     returns java.util.List<org.advancia.filippo.service.ToDo>
     */
    @WebMethod(operationName = "GEToDos", action = "get_todos")
    @WebResult(name = "toDosList", targetNamespace = "")
    @RequestWrapper(localName = "GEToDos", targetNamespace = "http://service.filippo.advancia.org/", className = "org.advancia.filippo.service.GEToDos")
    @ResponseWrapper(localName = "GEToDosResponse", targetNamespace = "http://service.filippo.advancia.org/", className = "org.advancia.filippo.service.GEToDosResponse")
    @Action(input = "get_todos", output = "http://service.filippo.advancia.org/ToDos/GEToDosResponse")
    public List<ToDo> geToDos();

    /**
     * 
     * @param toDoId
     * @return
     *     returns org.advancia.filippo.service.ToDo
     */
    @WebMethod
    @WebResult(name = "TODo", targetNamespace = "")
    @RequestWrapper(localName = "getToDo", targetNamespace = "http://service.filippo.advancia.org/", className = "org.advancia.filippo.service.GetToDo")
    @ResponseWrapper(localName = "getToDoResponse", targetNamespace = "http://service.filippo.advancia.org/", className = "org.advancia.filippo.service.GetToDoResponse")
    @Action(input = "http://service.filippo.advancia.org/ToDos/getToDoRequest", output = "http://service.filippo.advancia.org/ToDos/getToDoResponse")
    public ToDo getToDo(
        @WebParam(name = "toDoId", targetNamespace = "")
        int toDoId);

    /**
     * 
     * @param toDoToAdd
     * @return
     *     returns org.advancia.filippo.service.ToDo
     */
    @WebMethod
    @WebResult(name = "addedToDo", targetNamespace = "")
    @RequestWrapper(localName = "addToDo", targetNamespace = "http://service.filippo.advancia.org/", className = "org.advancia.filippo.service.AddToDo")
    @ResponseWrapper(localName = "addToDoResponse", targetNamespace = "http://service.filippo.advancia.org/", className = "org.advancia.filippo.service.AddToDoResponse")
    @Action(input = "http://service.filippo.advancia.org/ToDos/addToDoRequest", output = "http://service.filippo.advancia.org/ToDos/addToDoResponse")
    public ToDo addToDo(
        @WebParam(name = "toDoToAdd", targetNamespace = "")
        ToDo toDoToAdd);

    /**
     * 
     * @param toDoId
     * @throws ToDoException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "deleteToDo", targetNamespace = "http://service.filippo.advancia.org/", className = "org.advancia.filippo.service.DeleteToDo")
    @ResponseWrapper(localName = "deleteToDoResponse", targetNamespace = "http://service.filippo.advancia.org/", className = "org.advancia.filippo.service.DeleteToDoResponse")
    @Action(input = "http://service.filippo.advancia.org/ToDos/deleteToDoRequest", output = "http://service.filippo.advancia.org/ToDos/deleteToDoResponse", fault = {
        @FaultAction(className = ToDoException_Exception.class, value = "http://service.filippo.advancia.org/ToDos/deleteToDo/Fault/ToDoException")
    })
    public void deleteToDo(
        @WebParam(name = "toDoId", targetNamespace = "")
        int toDoId)
        throws ToDoException_Exception
    ;

    /**
     * 
     * @param updatedText
     * @param updatedTitle
     * @param toDoId
     * @return
     *     returns org.advancia.filippo.service.ToDo
     * @throws ToDoException_Exception
     */
    @WebMethod
    @WebResult(name = "UpdatedToDo", targetNamespace = "")
    @RequestWrapper(localName = "updateToDo", targetNamespace = "http://service.filippo.advancia.org/", className = "org.advancia.filippo.service.UpdateToDo")
    @ResponseWrapper(localName = "updateToDoResponse", targetNamespace = "http://service.filippo.advancia.org/", className = "org.advancia.filippo.service.UpdateToDoResponse")
    @Action(input = "http://service.filippo.advancia.org/ToDos/updateToDoRequest", output = "http://service.filippo.advancia.org/ToDos/updateToDoResponse", fault = {
        @FaultAction(className = ToDoException_Exception.class, value = "http://service.filippo.advancia.org/ToDos/updateToDo/Fault/ToDoException")
    })
    public ToDo updateToDo(
        @WebParam(name = "toDoId", targetNamespace = "")
        int toDoId,
        @WebParam(name = "updatedTitle", targetNamespace = "")
        String updatedTitle,
        @WebParam(name = "updatedText", targetNamespace = "")
        String updatedText)
        throws ToDoException_Exception
    ;

}
