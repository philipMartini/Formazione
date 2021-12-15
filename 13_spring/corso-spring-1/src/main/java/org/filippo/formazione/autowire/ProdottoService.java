package org.filippo.formazione.autowire;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component(value = "prodotto")
//Posso anche definire un bean usando @Named, oppure @ManagedBean da javaEE
public class ProdottoService {
	
	
	public String getProdotto() {
		return "Prodotto: " + new Date().getTime();
	}
}
