
package org.advancia.filippo.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.advancia.filippo.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetToDo_QNAME = new QName("http://service.filippo.advancia.org/", "getToDo");
    private final static QName _AddToDoResponse_QNAME = new QName("http://service.filippo.advancia.org/", "addToDoResponse");
    private final static QName _UpdateToDoResponse_QNAME = new QName("http://service.filippo.advancia.org/", "updateToDoResponse");
    private final static QName _DeleteToDo_QNAME = new QName("http://service.filippo.advancia.org/", "deleteToDo");
    private final static QName _GEToDosResponse_QNAME = new QName("http://service.filippo.advancia.org/", "GEToDosResponse");
    private final static QName _AddToDo_QNAME = new QName("http://service.filippo.advancia.org/", "addToDo");
    private final static QName _DeleteToDoResponse_QNAME = new QName("http://service.filippo.advancia.org/", "deleteToDoResponse");
    private final static QName _GEToDos_QNAME = new QName("http://service.filippo.advancia.org/", "GEToDos");
    private final static QName _UpdateToDo_QNAME = new QName("http://service.filippo.advancia.org/", "updateToDo");
    private final static QName _ToDo_QNAME = new QName("http://service.filippo.advancia.org/", "ToDo");
    private final static QName _ToDoException_QNAME = new QName("http://service.filippo.advancia.org/", "ToDoException");
    private final static QName _GetToDoResponse_QNAME = new QName("http://service.filippo.advancia.org/", "getToDoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.advancia.filippo.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ToDo }
     * 
     */
    public ToDo createToDo() {
        return new ToDo();
    }

    /**
     * Create an instance of {@link GEToDos }
     * 
     */
    public GEToDos createGEToDos() {
        return new GEToDos();
    }

    /**
     * Create an instance of {@link UpdateToDo }
     * 
     */
    public UpdateToDo createUpdateToDo() {
        return new UpdateToDo();
    }

    /**
     * Create an instance of {@link ToDoException }
     * 
     */
    public ToDoException createToDoException() {
        return new ToDoException();
    }

    /**
     * Create an instance of {@link GetToDoResponse }
     * 
     */
    public GetToDoResponse createGetToDoResponse() {
        return new GetToDoResponse();
    }

    /**
     * Create an instance of {@link GetToDo }
     * 
     */
    public GetToDo createGetToDo() {
        return new GetToDo();
    }

    /**
     * Create an instance of {@link DeleteToDo }
     * 
     */
    public DeleteToDo createDeleteToDo() {
        return new DeleteToDo();
    }

    /**
     * Create an instance of {@link GEToDosResponse }
     * 
     */
    public GEToDosResponse createGEToDosResponse() {
        return new GEToDosResponse();
    }

    /**
     * Create an instance of {@link AddToDo }
     * 
     */
    public AddToDo createAddToDo() {
        return new AddToDo();
    }

    /**
     * Create an instance of {@link DeleteToDoResponse }
     * 
     */
    public DeleteToDoResponse createDeleteToDoResponse() {
        return new DeleteToDoResponse();
    }

    /**
     * Create an instance of {@link AddToDoResponse }
     * 
     */
    public AddToDoResponse createAddToDoResponse() {
        return new AddToDoResponse();
    }

    /**
     * Create an instance of {@link UpdateToDoResponse }
     * 
     */
    public UpdateToDoResponse createUpdateToDoResponse() {
        return new UpdateToDoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetToDo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.filippo.advancia.org/", name = "getToDo")
    public JAXBElement<GetToDo> createGetToDo(GetToDo value) {
        return new JAXBElement<GetToDo>(_GetToDo_QNAME, GetToDo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddToDoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.filippo.advancia.org/", name = "addToDoResponse")
    public JAXBElement<AddToDoResponse> createAddToDoResponse(AddToDoResponse value) {
        return new JAXBElement<AddToDoResponse>(_AddToDoResponse_QNAME, AddToDoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateToDoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.filippo.advancia.org/", name = "updateToDoResponse")
    public JAXBElement<UpdateToDoResponse> createUpdateToDoResponse(UpdateToDoResponse value) {
        return new JAXBElement<UpdateToDoResponse>(_UpdateToDoResponse_QNAME, UpdateToDoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteToDo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.filippo.advancia.org/", name = "deleteToDo")
    public JAXBElement<DeleteToDo> createDeleteToDo(DeleteToDo value) {
        return new JAXBElement<DeleteToDo>(_DeleteToDo_QNAME, DeleteToDo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GEToDosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.filippo.advancia.org/", name = "GEToDosResponse")
    public JAXBElement<GEToDosResponse> createGEToDosResponse(GEToDosResponse value) {
        return new JAXBElement<GEToDosResponse>(_GEToDosResponse_QNAME, GEToDosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddToDo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.filippo.advancia.org/", name = "addToDo")
    public JAXBElement<AddToDo> createAddToDo(AddToDo value) {
        return new JAXBElement<AddToDo>(_AddToDo_QNAME, AddToDo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteToDoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.filippo.advancia.org/", name = "deleteToDoResponse")
    public JAXBElement<DeleteToDoResponse> createDeleteToDoResponse(DeleteToDoResponse value) {
        return new JAXBElement<DeleteToDoResponse>(_DeleteToDoResponse_QNAME, DeleteToDoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GEToDos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.filippo.advancia.org/", name = "GEToDos")
    public JAXBElement<GEToDos> createGEToDos(GEToDos value) {
        return new JAXBElement<GEToDos>(_GEToDos_QNAME, GEToDos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateToDo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.filippo.advancia.org/", name = "updateToDo")
    public JAXBElement<UpdateToDo> createUpdateToDo(UpdateToDo value) {
        return new JAXBElement<UpdateToDo>(_UpdateToDo_QNAME, UpdateToDo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ToDo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.filippo.advancia.org/", name = "ToDo")
    public JAXBElement<ToDo> createToDo(ToDo value) {
        return new JAXBElement<ToDo>(_ToDo_QNAME, ToDo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ToDoException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.filippo.advancia.org/", name = "ToDoException")
    public JAXBElement<ToDoException> createToDoException(ToDoException value) {
        return new JAXBElement<ToDoException>(_ToDoException_QNAME, ToDoException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetToDoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.filippo.advancia.org/", name = "getToDoResponse")
    public JAXBElement<GetToDoResponse> createGetToDoResponse(GetToDoResponse value) {
        return new JAXBElement<GetToDoResponse>(_GetToDoResponse_QNAME, GetToDoResponse.class, null, value);
    }

}
