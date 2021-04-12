
package org.advancia.filippo.service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ToDosService", targetNamespace = "http://service.filippo.advancia.org/", wsdlLocation = "http://filippo-xps-13-7390:8080/toDoSoap/ToDosService?wsdl")
public class ToDosService
    extends Service
{

    private final static URL TODOSSERVICE_WSDL_LOCATION;
    private final static WebServiceException TODOSSERVICE_EXCEPTION;
    private final static QName TODOSSERVICE_QNAME = new QName("http://service.filippo.advancia.org/", "ToDosService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://filippo-xps-13-7390:8080/toDoSoap/ToDosService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        TODOSSERVICE_WSDL_LOCATION = url;
        TODOSSERVICE_EXCEPTION = e;
    }

    public ToDosService() {
        super(__getWsdlLocation(), TODOSSERVICE_QNAME);
    }

    public ToDosService(WebServiceFeature... features) {
        super(__getWsdlLocation(), TODOSSERVICE_QNAME, features);
    }

    public ToDosService(URL wsdlLocation) {
        super(wsdlLocation, TODOSSERVICE_QNAME);
    }

    public ToDosService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, TODOSSERVICE_QNAME, features);
    }

    public ToDosService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ToDosService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ToDos
     */
    @WebEndpoint(name = "ToDosServicePort")
    public ToDos getToDosServicePort() {
        return super.getPort(new QName("http://service.filippo.advancia.org/", "ToDosServicePort"), ToDos.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ToDos
     */
    @WebEndpoint(name = "ToDosServicePort")
    public ToDos getToDosServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://service.filippo.advancia.org/", "ToDosServicePort"), ToDos.class, features);
    }

    private static URL __getWsdlLocation() {
        if (TODOSSERVICE_EXCEPTION!= null) {
            throw TODOSSERVICE_EXCEPTION;
        }
        return TODOSSERVICE_WSDL_LOCATION;
    }

}
