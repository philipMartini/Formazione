package org.advancia.filippo.publisher;

import javax.xml.ws.Endpoint;

import org.advancia.filippo.service.ProductCatalog;

public class TestMartPublisher {
	
	
	public static void main(String args[]){
		//La reference implemetation METRO effettua la pubblicazione del WS
		//é presente anche nella JDK, anche glassfish ne ha una ovviamente
		//Questo metodo è SINGLE THREAD!!!!!
		//Su glassfish ovviamente ogni richiesta è un thread quindi siamo a posto.
		Endpoint.publish("http://localhost:1234/productcatalog", new ProductCatalog());
	}
}
