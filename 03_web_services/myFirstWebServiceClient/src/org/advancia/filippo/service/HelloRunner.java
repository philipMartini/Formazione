package org.advancia.filippo.service;

public class HelloRunner {

	public static void main(String[] args) {
		HelloService service = new HelloService();
		Hello hello = service.getHelloPort();
		System.out.println(hello.hello("Filippo"));

	}

}
