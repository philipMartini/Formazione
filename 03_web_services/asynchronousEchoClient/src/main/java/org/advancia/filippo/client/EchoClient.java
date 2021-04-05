package org.advancia.filippo.client;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;

public class EchoClient {

    public static void main(String[] args) throws Exception {
        ServiceClient client = new ServiceClient();
        Options opts = new Options();
        // opts.setTo(new EndpointReference("http://localhost:6060/axis2/services/EchoService"));
        // mi da l'url per la connessione al servizio: se l'url è errato mi dà connection refused
        opts.setTo(new EndpointReference("http://localhost:8080/echoService/services/EchoService.EchoServiceHttpSoap11Endpoint/"));
        // opts.setTo(new EndpointReference("http://localhost:8084/axis2/services/NewAxisFromJava"));
        // setto qui il metodo del web service che voglio richiamare
        opts.setAction("urn:echo");
        client.setOptions(opts);
        // metodo che gestisce l'asincronicità della richiesta:
        //  createPayLoad()  --> the data to send (becomes the content of SOAP body)
        //  new MyCallBack()--> a Callback which will be notified upon completion
//        Directly invoke an anonymous operation with an In-Out MEP without waiting for a response.
//        This method sends your supplied XML with response notification to your callback handler.
//        For more control, you can instead create a client
//        for the operation and use that client to execute the exchange.
        client.sendReceiveNonBlocking(createPayLoad(), new MyCallBack());
        System.out.println("send the message");
        while (true) {
            System.out.println("prima dell'attesa");
            Thread.sleep(1000);
            System.out.println("dopo l'attesa");
        }
    }
    // metodo che gestisce il pacchetto di dati da inviare per la chiamata al web service

    public static OMElement createPayLoad() {
        OMFactory fac = OMAbstractFactory.getOMFactory();
        // setto qui il name space del file wsdl
        OMNamespace omNs = fac.createOMNamespace("http://service.filippo.advancia.org", "ns");
        // OMNamespace omNs = fac.createOMNamespace("http://webservice/xsd", "ns");
        //setto il metodo in questione
        OMElement method = fac.createOMElement("echo", omNs);
        //OMElement method = fac.createOMElement("hello", omNs);
        //setto il valore da passare come parametro
        OMElement value = fac.createOMElement("value", omNs);
        // metodo da cui passo il valore
        method.addChild(value);
        // setto il valore del parametro passato
        value.setText("francesco");
        OMElement value2 = fac.createOMElement("value", omNs);
        // metodo da cui passo il valore
        method.addChild(value2);
        // setto il valore del parametro passato
        value2.setText("rrrrrrr");
        return method;

    }
}
