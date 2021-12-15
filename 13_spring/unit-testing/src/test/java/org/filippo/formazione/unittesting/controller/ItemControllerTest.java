package org.filippo.formazione.unittesting.controller;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.filippo.formazione.unittesting.business.ItemBusinessService;
import org.filippo.formazione.unittesting.model.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(ItemController.class)
class ItemControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	//Questa annotazione serve a fare inj del bean presente nel controller
	@MockBean
	private ItemBusinessService mockService;
	
	@Test
	void getItemBasicTest() throws Exception {
		
		//Build the request
		RequestBuilder request = MockMvcRequestBuilders
				.get("/dummy-item")
				.accept(MediaType.APPLICATION_JSON);
				
		//Call /uri
		MvcResult response = this.mockMvc.perform(request)
										.andExpect(status().is(200))
										.andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":3,\"quantity\":7}"))
										.andReturn();
		//verify that the response content is the correct Item object
		//assertEquals("Hello World", response.getResponse().getContentAsString());
	}
	
	
	@Test
	void getItemFromBusinessServiceBasicTest() throws Exception {
		
		//Qui serve fare mocking, perche se non lo facessi il metodo del service mi restiurebbe null
		when(this.mockService.retriveHarcodedItem()).thenReturn(new Item(1, "Ball", 3, 7));
		
		//Build the request
		RequestBuilder request = MockMvcRequestBuilders
				.get("/item-from-business-service")
				.accept(MediaType.APPLICATION_JSON);
				
		//Call /item
		MvcResult response = this.mockMvc.perform(request)
										.andExpect(status().is(200))
										.andExpect(content().json("{id:1,name:Ball, price:3,quantity:7}"))
										.andReturn();
		//verify that the response content is the correct Item object
		//assertEquals("Hello World", response.getResponse().getContentAsString());
	}
	
	@Test
	void retriveAllItemsBasicTest() throws Exception {
		
		//Qui serve fare mocking, perche se non lo facessi il metodo del service mi restiurebbe null
		when(this.mockService.retriveAllItems()).thenReturn(
				Arrays.asList(new Item(2, "Item2", 10, 10), new Item(3, "Item3", 10, 10))
				);
		
		//Build the request
		RequestBuilder request = MockMvcRequestBuilders
				.get("/all-items-from-db")
				.accept(MediaType.APPLICATION_JSON);
				
		//Call /item
		MvcResult response = this.mockMvc.perform(request)
										.andExpect(status().is(200))
										.andExpect(content().json("[{id:2,name:Item2, price:10,quantity:10},{id:3,name:Item3, price:10,quantity:10} ]"))
										.andReturn();
		//verify that the response content is the correct Item object
		//assertEquals("Hello World", response.getResponse().getContentAsString());
	}

}
