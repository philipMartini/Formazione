package org.advancia.filippo.client;

import org.apache.axis2.client.async.AxisCallback;
import org.apache.axis2.context.MessageContext;
import org.apache.axiom.soap.SOAPBody;

public class MyCallBack implements AxisCallback {

    // metodo che riceve il messaggio dal web service
    public void onMessage(MessageContext messageContext) {
        SOAPBody msg = messageContext.getEnvelope().getBody();
        System.out.println(msg);
    }
    //metodo richiamato quando si riceve un messaggio di errore
    public void onFault(MessageContext messageContext) {
        System.out.println("msnContext error");
        messageContext.getFailureReason().printStackTrace();
    }

    // metodo richiamato solo in caso di un messaggio d'errore
    public void onError(Exception e) {
        System.err.println(e.getMessage());
    }

    //  this method is called at the end of the MEP no matter what happens, quite like a finally block.
    public void onComplete() {
        System.out.println("Invocation is complete");       
        System.exit(0);
    }
}
