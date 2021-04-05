package org.advancia.filippo.runner;

import java.rmi.RemoteException;

import org.advancia.filippo.service.HelloClassStub;
import org.apache.axis2.AxisFault;

public class Test {

	public static void main(String[] args) throws RemoteException {
		try {
			HelloClassStub classStub = new HelloClassStub();
			
			HelloClassStub.Hello hello = new HelloClassStub.Hello();
			hello.setName("Filippo");
			
			
			String result = classStub.hello(hello).get_return();
			System.out.println(result);
			
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
