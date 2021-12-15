package io.javabrains.springbootsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//Configuro Spring Sec per autenticazione di una web app
@EnableWebSecurity
//Estendendo questa classe posso configurare l'autenticazione
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    
	
	//Spring security chiama questo metodo passando il builder e in tal modo posso settare
	//Le configurazioni nel builder
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Set your configuration on the auth object
        auth.inMemoryAuthentication()
                .withUser("blah") //Utente 1
                .password("blah")
                .roles("USER") // roles == gruppi di autorizzazioni
                .and()
                .withUser("foo") //Utente 2
                .password("foo")
                .roles("ADMIN");
    }

    @Bean
    //Qeusto bean viene usato da Spring Sec per memorizzare le pass in in clear text ma un hash
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
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
}
