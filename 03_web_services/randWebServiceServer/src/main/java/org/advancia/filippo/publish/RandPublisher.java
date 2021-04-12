package org.advancia.filippo.publish;

import javax.xml.ws.Endpoint;

import org.advancia.filippo.service.RandService;

public class RandPublisher {
	
	public static final void main(String [] args) {
		final String url  = "http://localhost:7777/rs";
		System.out.println("Publishing service at " + url);
		Endpoint.publish(url, new RandService());
	}
}
