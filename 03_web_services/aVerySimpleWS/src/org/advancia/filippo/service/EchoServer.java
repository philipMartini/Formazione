package org.advancia.filippo.service;

import org.apache.axis2.AxisFault;
import org.apache.axis2.engine.AxisServer;

public class EchoServer {
	
	public static void main(String[] args){
		try {
			new AxisServer().deployService(EchoService.class.getName());
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
