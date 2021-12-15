package org.filippo.formazione.autowire;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "ordine")
public class OrdineService {
	
	//@Resource è un modo alternativo di fare injectin su variabili di istanza o setter
	//Posso specificare anche il nome del bean da iniettare questa annotation è di JavaEE
	//@Resource(name = "cliente")
	//Posso usare anche la javax ann @Inject per effettuare autowiring
	@Inject
	private ClienteService cliente;
	
	
	
	//Posso fare autowiring anche direttamente sulle variabili di istanza
	@Autowired
	private ProdottoService prodotto;
	
	
//	//Con un solo costruttore l'autowire avviene in automatico
//	@Autowired
//	public OrdineService(ClienteService cliente) {
//		super();
//		this.cliente = cliente;
//		//this.prodotto = prodotto;
//	}
//	
//	//Se ne aggiungo un altro, devo esplicitarlo nel costruttore che ha come parametri i bean da istanziare
//	public OrdineService() {
//		super();
//		
//	}
	
	public String getOrdineInfo() {
		
		return new Date().toString() + " info cliente: " + this.cliente.getInfo() +" " +  this.prodotto.getProdotto();
	}
	
	//Ovviamnete posso usare anche la setter injection per l'autowiring basta specifiarlo con l'annotazione
	//@Autowired
	public void setCliente(ClienteService cliente) {
		this.cliente = cliente;
	}
	
	
	//Posso usare l'autowiring anche su un metodo non costruttore che ha bisogno di inj di altri bean
	//@Autowired
	public void recuperaServices(ClienteService clienteService, ProdottoService prodottoService) {
		this.cliente = clienteService;
		this.prodotto = prodottoService;
	}
	
	
	//Invoca questo metodo appena hai costruito il bean
	@PostConstruct
	public void init() {
		System.out.println("Inside init!");
	}
	
	//Invoca questo metodo prima di distruggere il bean
	@PreDestroy
	public void destroy() {
		System.out.println("Inside destroy!");
	}

	
}
