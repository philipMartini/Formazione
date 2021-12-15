package org.filippo.formazione.springsecurityjpa.repository;

import java.util.Optional;

import org.filippo.formazione.springsecurityjpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	Optional<User> findByUserName(String userName);
}
