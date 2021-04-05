package org.advancia.filippo.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style=Style.RPC)
public class Hello {
	
	@WebMethod
	public String hello(String name){
		return "Hello " + name + " from the WEB SERVICE";
	}
}
