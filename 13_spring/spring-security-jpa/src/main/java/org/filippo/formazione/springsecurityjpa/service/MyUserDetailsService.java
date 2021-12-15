package org.filippo.formazione.springsecurityjpa.service;

import java.util.Optional;

import org.filippo.formazione.springsecurityjpa.model.MyUserDetails;
import org.filippo.formazione.springsecurityjpa.model.User;
import org.filippo.formazione.springsecurityjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userDetailsRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<User>  user = this.userDetailsRepository.findByUserName(userName);
		user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));
		return new MyUserDetails(user.get());
	}

}
