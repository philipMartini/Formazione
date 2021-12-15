package org.filippo.formazione.unittesting.controller;

import org.filippo.formazione.unittesting.data.ItemRepository;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

//In questo caso tutti i componenti della app vengono lanciati
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT) //Viene scelta una porta disponibile
class ItemControllerIT {
	
	//Il rest template per le requests sa già su quale porta l'app ascolta
	@Autowired
	private TestRestTemplate restTemplate;
	
	//Ma se ci fossero classi che comunicano con servizi esterni come db, come posso fare mocking?
	//Escludendo di dipendere dai dati presenti nei servizi esterni in quel momento
	//@MockBean
	//private ItemRepository repository;
	
	@Test
	void contextLoadsTest() throws JSONException {
		String stringResponse = this.restTemplate.getForObject("/all-items-from-db", String.class);
		
		JSONAssert.assertEquals("[{id:1001}, {id:1002}, {id:1003}]", stringResponse, false);
	}

}
