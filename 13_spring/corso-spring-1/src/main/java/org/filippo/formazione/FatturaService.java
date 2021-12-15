package org.filippo.formazione;

public class FatturaService {
	
	private OrdineService ordineService;
	private ClienteService clienteService;
	private String numeroFattura;
	private int mese;
	
	public FatturaService(OrdineService ordineService, ClienteService clienteService, String numeroFattura, int mese) {
		super();
		this.ordineService = ordineService;
		this.clienteService = clienteService;
		this.numeroFattura = numeroFattura;
		this.mese = mese;
	}

	public String stampaFattura() {
		
		return this.numeroFattura + " "+ this.clienteService.getHelloMessage() +" " 
		+ this.ordineService.listaProdotti() + " " + this.mese;
	}

	public String getNumeroFattura() {
		return numeroFattura;
	}

	public void setNumeroFattura(String numeroFattura) {
		this.numeroFattura = numeroFattura;
	}
	
	
}
