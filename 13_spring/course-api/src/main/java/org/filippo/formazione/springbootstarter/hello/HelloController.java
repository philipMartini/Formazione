package org.filippo.formazione.springbootstarter.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//QUesta annotazione rende questa classe una REST API
@RestController
public class HelloController {
	
	//Questa annotazione fa in modo che il metodo sia eseguito
	//Quando viene effettuata una GET allo url specificato
	@RequestMapping("/hello")
	public String sayHi() {
		return "Hi!";
	}
}
