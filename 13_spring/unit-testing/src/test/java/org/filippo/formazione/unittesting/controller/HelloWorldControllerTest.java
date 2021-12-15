package org.filippo.formazione.unittesting.controller;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(HelloWorldController.class)
class HelloWorldControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	void helloWorldBasicTest() throws Exception {
		
		//Build the request
		RequestBuilder request = MockMvcRequestBuilders
				.get("/hello-world")
				.accept(MediaType.APPLICATION_JSON);
				
		//Call /hello-world
		MvcResult response = this.mockMvc.perform(request)
										.andExpect(status().is(200))
										.andExpect(content().string("Hello World"))
										.andReturn();
		//verify that the response content is HelloWorld
		//assertEquals("Hello World", response.getResponse().getContentAsString());
	}

}
