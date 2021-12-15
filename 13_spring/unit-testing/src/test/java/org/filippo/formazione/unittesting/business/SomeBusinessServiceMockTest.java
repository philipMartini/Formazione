package org.filippo.formazione.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.filippo.formazione.unittesting.data.SomeDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


//Ed è qui che il mocking diventa fondamentale

@ExtendWith(MockitoExtension.class)
class SomeBusinessServiceMockTest {
	//Al posto di usare direttamente il setter della classe posso fare injection......
	@InjectMocks
	SomeBusinessService business;
	//...Di questo Mock che uso nel business service
	@Mock
	SomeDataService dataServiceMock;
	
//	@BeforeEach
//	void beforeEachTest() {
//		this.business = new SomeBusinessService();
//		//Creare un mock di una certa classe
//		this.dataServiceMock = mock(SomeDataService.class);
//		business.setDataService(dataServiceMock);
//	}

	@Test
	void calculateSumUsingDataServiceBasicTest() {
		
		//E ora come posso assegnare i valori che avevo settato nello stub ie [1,2,3,1]????
		//Quando viene chiamato il metodo di dataServiceMock retriveAllData() restituisci l'array {1,2,3,1}
		when(dataServiceMock.retriveAllData()).thenReturn(new int[] {1,2,3,1});
		assertEquals(7, business.calculateSumUsingDataService());
	}
	
	
	  @Test 
	  void calculateSumEmptyArrayTest() { 
		 
			//Quando viene chiamato il metodo di dataServiceMock retriveAllData() restituisci l'array {}
			when(dataServiceMock.retriveAllData()).thenReturn(new int[] {});
			assertEquals(0, business.calculateSumUsingDataService());
		  
	  }
	  
	  @Test 
	  void calculateSumOneElementArrayTest() { 
			//Quando viene chiamato il metodo di dataServiceMock retriveAllData() restituisci l'array {7}
			when(dataServiceMock.retriveAllData()).thenReturn(new int[] {7});
			assertEquals(7, business.calculateSumUsingDataService());	  
	  }
	 

}
