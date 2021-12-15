package org.filippo.formazione;

public class BeanA {
	
	//Questo Bean non usa direttamente il Bean B ma ha bisogno che venga eseguito il blocco di codice
	//Statico contenuto in esso( ad es iniziallizzazione conn al db)
	//Quindi non dipende direttamente da B
	public void getMessage() {
		System.out.println("Sono nel BeanA");
	}
}
