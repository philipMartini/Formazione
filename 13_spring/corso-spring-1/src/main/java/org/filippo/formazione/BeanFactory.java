package org.filippo.formazione;

public class BeanFactory {
	
	private static OrdineService ordineService = new OrdineService();
	private static ProdottoService prodottoService = new ProdottoService();
	
	public static OrdineService getOrdineService() {
		return ordineService;
	}
	
	public static ProdottoService getProdottoService() {
		return prodottoService;
	}
}
