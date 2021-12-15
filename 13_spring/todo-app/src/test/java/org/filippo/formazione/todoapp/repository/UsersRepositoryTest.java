package org.filippo.formazione.todoapp.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.filippo.formazione.todoapp.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

@TestPropertySource("/tests.properties")
@DataJpaTest
class UsersRepositoryTest {
	
	@Autowired
	private UsersRepository userRepository;
	
	private List<User> users;
	
	@BeforeEach
	private void initListAsInDb() {
		this.users = Arrays.asList(
				new User("foo@foo.com", "testPass"), 
				new User("bar@bar.com", "myPass"),
				new User("john@doe.com", "pwd")
				
				);
	}
	
	@Test
	void findAlltest() {
		List<User> usersFromDb = (List<User>) this.userRepository.findAll();
		assertEquals(3, usersFromDb.size());
		assertTrue(usersFromDb.contains(this.users.get(0)));
		assertTrue(usersFromDb.contains(this.users.get(1)));
		assertTrue(usersFromDb.contains(this.users.get(2)));
	}
	
	@Test
	void findUserByIdTest() {
		assertEquals(this.users.get(0), this.userRepository.findById("foo@foo.com").get());
		
	}
	
	@Test 
	void saveUserTest() {
		User toAdd = new User("admin@admin.com", "admin");
		this.userRepository.save(toAdd);
		assertEquals(toAdd, this.userRepository.findById("admin@admin.com").get());	
	}
	
	@Test
	void updateUserTest() {
		User toUpdate = new User("admin@admin.com", "admin");
		this.userRepository.save(toUpdate);
		toUpdate.setPassword("adminPass");
		this.userRepository.save(toUpdate);
		assertEquals(toUpdate.getPassword(), this.userRepository.findById("admin@admin.com").get().getPassword());
	}
	

}
