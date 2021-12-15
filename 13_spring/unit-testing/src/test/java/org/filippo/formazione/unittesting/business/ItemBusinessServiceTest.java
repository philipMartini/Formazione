package org.filippo.formazione.unittesting.business;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.filippo.formazione.unittesting.data.ItemRepository;
import org.filippo.formazione.unittesting.model.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ItemBusinessServiceTest {
	
	//Facciamo Mocking del servizio di accesso al db
	@Mock
	private ItemRepository dataRepository;
	
	//E lo iniettiamo nel business service
	@InjectMocks
	private ItemBusinessService businessService;
	
	
	@Test
	public void retriveAllItemsBasicTest() {
		
		when(this.dataRepository.findAll()).thenReturn(
				Arrays.asList(new Item(2, "Item2", 10, 10), new Item(3, "Item3", 10, 10))
				);
		List<Item> items = this.businessService.retriveAllItems();
		//Qui fai tutti gli assert che vuoi
		//assertThat(items, hasSize(2));
	}
	

}
