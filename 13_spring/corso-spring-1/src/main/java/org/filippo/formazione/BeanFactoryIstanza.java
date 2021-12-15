package org.filippo.formazione;

public class BeanFactoryIstanza {
	
	private  OrdineService ordineService = new OrdineService();
	private  ProdottoService prodottoService = new ProdottoService();
	
	public OrdineService getOrdineService() {
		return ordineService;
	}
	
	public ProdottoService getProdottoService() {
		return prodottoService;
	}
}
