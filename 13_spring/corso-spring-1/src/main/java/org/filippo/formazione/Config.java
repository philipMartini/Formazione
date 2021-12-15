package org.filippo.formazione;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Questo è lequivalente del file beans.xml
@Configuration
public class Config {
	
	@Bean(name = "ordineServiceAnnotation")
	public OrdineService getOrdineService() {
		return new OrdineService();
	}
	
}
