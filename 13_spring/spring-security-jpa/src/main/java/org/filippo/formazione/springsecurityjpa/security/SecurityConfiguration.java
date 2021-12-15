package org.filippo.formazione.springsecurityjpa.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//Qui andiamo a chiamare l'appropriato AuthProvider, che a sua volta deve chiamare Lo UserDetailsService
		//Per recuperare le credenziali.
		//Per funzionare basta che il servizio implementi l'interfaccia UserdetailsService
		//Qui viene effettuata l'autenticazione
		auth.userDetailsService(userDetailsService);
	}
	
	
	 @Override
	    //HttpSecurity è l'oggetto che permette di configurare le autorizzazioni
	    protected void configure(HttpSecurity http) throws Exception {
	        //L'ordine non è casuale si va da MOST a LESS restrictive
	    	http.authorizeRequests()
	                .antMatchers("/admin").hasRole("ADMIN") // Qui avviene il mapping tra path e ruoli. Posso usare anche wildcards ad esempio /user* matcha tutti i path che iniziano con /user
	                .antMatchers("/user").hasAnyRole("ADMIN", "USER")
	                .antMatchers("/").permitAll()
	                .and().formLogin(); // CI sono altre opzioni di login, ma questa è di default
	    }
	 
	 @Bean
    //Qeusto bean viene usato da Spring Sec per memorizzare le pass in in clear text ma un hash
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
	
}
