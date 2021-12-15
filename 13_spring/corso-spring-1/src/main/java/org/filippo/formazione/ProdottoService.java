package org.filippo.formazione;

import java.util.Date;

public class ProdottoService {
	
//Metodo che viene chiamato nella fase post-initialization nel ciclo di vita del bean
	//Nell'xml va specificata la property init-method
	public void init() {
		System.out.println("Sono in init()");
	}
	
	//Questo metodo permette di eseguire azioni in fase di destroy del bean => nell'xml va specificato
	//l'attributo destroy-method
	public void clean() {
		System.out.println("Sono in clean()");
	}
	
	
	
	public String getProdotto() {
		return "Telefono" + new Date().getTime();
	}
	
	public String[] getListaProdotti() {
		return new String[] {"Prodotto 1", "Prodotto 2", "Prodotto 3"};
	}
	
}
