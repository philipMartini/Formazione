package org.filippo.formazione.todoapp.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.filippo.formazione.todoapp.model.User;
import org.filippo.formazione.todoapp.service.BusinessService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(ToDoAppController.class)
class ToDoAppControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private BusinessService service;
	
	@Test
	void getUsersTest() throws Exception {
		
		Mockito.when(this.service.getAllUsers()).thenReturn(Arrays.asList(
				new User("foo@foo.com", "testPass"), 
				new User("bar@bar.com", "myPass"),
				new User("john@doe.com", "pwd")
				
				));
		
		
		//Build the request
		RequestBuilder request = MockMvcRequestBuilders
				.get("/todo-app/users/")
				.accept(MediaType.APPLICATION_JSON);
						
		//Call /uri
		MvcResult response = this.mockMvc.perform(request)
										.andExpect(status().is(200))
										.andReturn();
		
		String expectedJSONResponse = "[{email: foo@foo.com, password: testPass}, "
				+ "{email: bar@bar.com, password: myPass}, "
				+ "{email: john@doe.com, password: pwd}]";
		
		//System.out.println(response.getResponse().getContentAsString());
		JSONAssert.assertEquals(expectedJSONResponse, response.getResponse().getContentAsString(), true);
	}
	
	@Test
	void getUserTest() throws Exception {
		String userId = "foo@foo.com";
		Mockito.when(this.service.getUser(userId)).thenReturn(new User("foo@foo.com", "testPass"));
		
		
		RequestBuilder request = MockMvcRequestBuilders
									.get("/todo-app/users/{userId}", userId)
									.accept(MediaType.APPLICATION_JSON);
		
		MvcResult response = this.mockMvc.perform(request)
								.andExpect(status().is(200))
								.andReturn();
		String expectedJSONResponse = "{email: foo@foo.com, password: testPass}";
		JSONAssert.assertEquals(expectedJSONResponse, response.getResponse().getContentAsString(), true);
	}

}
