package org.filippo.formazione;

public class OrdineService {
	
	
	private ProdottoService prodottoService;
	
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
	
	public String hello() {
		return "Hello World!";
	}

	
	
	public ProdottoService getProdottoService() {
		return prodottoService;
	}

	public void setProdottoService(ProdottoService prodottoService) {
		this.prodottoService = prodottoService;
	}

	public String[] listaProdotti() {
		return this.prodottoService.getListaProdotti();
	}
	
}
