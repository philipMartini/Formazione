package org.filippo.formazione.autowire;

import org.springframework.stereotype.Component;

@Component(value = "cliente")
public class ClienteService {
	
	
	public String getInfo() { return "Filippo Martini"; }
}
