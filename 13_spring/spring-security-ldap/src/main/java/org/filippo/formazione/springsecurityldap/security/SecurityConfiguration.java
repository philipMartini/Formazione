package org.filippo.formazione.springsecurityldap.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//Qui andiamo a configurare l'appropriato AuthProvider cioè quello per ldap,
		auth.ldapAuthentication()
				.userDnPatterns("uid={0}, ou=people") //Come sono storate le info sul db
				.groupSearchBase("ou=groups")
				.contextSource()
				.url("ldap://localhost:8389/dc=springframework,dc=org")
			.and()
				.passwordCompare()
				.passwordEncoder(new BCryptPasswordEncoder())
				.passwordAttribute("userPassword");
	}
	
	
	
	@Override
    //HttpSecurity è l'oggetto che permette di configurare le autorizzazioni
    protected void configure(HttpSecurity http) throws Exception {
        //L'ordine non è casuale si va da MOST a LESS restrictive
    	http.authorizeRequests()
             .anyRequest().fullyAuthenticated()
             .and()
             .formLogin();
    }

}
