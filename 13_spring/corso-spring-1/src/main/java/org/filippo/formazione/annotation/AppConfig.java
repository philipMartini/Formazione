package org.filippo.formazione.annotation;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.Scope;

//Questa annotazione permette di sostituire il file xml di configurazione
//Ovviamnete cambierà anche la classe con cui recupero il context
@Configuration
public class AppConfig {
	
	@Bean(name = "phoneBean")
	public Phone getPhone() {
		return new Phone();
	}
	
	//Usa questo metodo per istanziare/recuperare il bean User
	@Bean(name = "userBean", initMethod = "init", destroyMethod = "destroy")
	@Scope(value = "singleton")
	@Description("This is a test description for the bean User")
	public User getUser() {
		return new User(this.getPhone());
	}
}
