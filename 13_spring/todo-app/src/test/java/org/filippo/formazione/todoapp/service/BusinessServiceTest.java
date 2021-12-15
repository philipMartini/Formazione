package org.filippo.formazione.todoapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.filippo.formazione.todoapp.model.User;
import org.filippo.formazione.todoapp.repository.ToDoRepository;
import org.filippo.formazione.todoapp.repository.UsersRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.creation.util.MockitoMethodProxy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BusinessServiceTest {
	
	
	@Mock
	private ToDoRepository toDoRepository;
	@Mock 
	private UsersRepository userRepository;
	
	@InjectMocks
	private BusinessService service;
	
	
	@Test
	void getAllUsersEmptyTest() {
		Mockito.when(this.userRepository.findAll()).thenReturn(Arrays.asList());
		assertEquals(this.service.getAllUsers().size(), 0);
	}
	
	@Test 
	void getAllUsersNonEmptyTest(){
		Mockito.when(this.userRepository.findAll()).thenReturn(Arrays.asList(
				new User("foo@foo.com", "testPass"), 
				new User("bar@bar.com", "myPass"),
				new User("john@doe.com", "pwd")
				
				));
		List<User> users = this.service.getAllUsers();
		assertEquals(users.size(), 3);
		assertTrue(users.contains(new User("foo@foo.com", "testPass")));
		assertTrue(users.contains(new User("bar@bar.com", "myPass")));
		assertTrue(users.contains(new User("john@doe.com", "pwd")));
	}
	
	@Test
	void addUserTest() {
		User user = new User("foo@foo.com", "testPass");
		this.service.addUser(user);
		ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);
		//Qui ha senso verificare che venga effettuata una chiamata perchè è il metodo save che fa il lavoro
		Mockito.verify(this.userRepository).save(captor.capture());
		assertEquals(user, captor.getValue());
	}
	
	@Test
	void updateUser() {
		String userId = "foo@foo.com";
		User user = new User("someFakeId", "testPass");
		
		this.service.updateUser(userId, user);
		
		user.setEmail(userId);
		
		ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);
		Mockito.verify(this.userRepository).save(captor.capture());
		assertEquals(user, captor.getValue());
	}
	
	@Test
	void deleteUser() {
		String userId = "foo@foo.com";
		this.service.deleteUser(userId);
		
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		Mockito.verify(this.userRepository).deleteById(captor.capture());
		assertEquals(userId, captor.getValue());
	}

}
