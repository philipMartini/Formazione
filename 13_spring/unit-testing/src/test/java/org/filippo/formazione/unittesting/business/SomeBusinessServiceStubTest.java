package org.filippo.formazione.unittesting.business;

import static org.junit.jupiter.api.Assertions.*;

import org.filippo.formazione.unittesting.data.SomeDataService;
import org.junit.jupiter.api.Test;


//Non voglio che i miei tests interroghino direttamente il DB e quindi come simulo l'interazione con il data layer?
//Creo una classe stub apposta per fare i tests!!!!
class SomeDataServiceStub implements SomeDataService{

	@Override
	public int[] retriveAllData() {
		
		return new int[] {1,2,3,1};
	}
	
}

//Si inizia a capire quale sia il problema per numerosi casi di test.......
class SomeDataServiceEmptyStub implements SomeDataService{

	@Override
	public int[] retriveAllData() {
		
		return new int[] {};
	}
	
}

//Ed è qui che il mocking diventa fondamentale


class SomeBusinessServiceStubTest {
	


	@Test
	void calculateSumUsingDataServiceBasicTest() {
		SomeBusinessService business = new SomeBusinessService();
		business.setDataService(new SomeDataServiceStub());
		assertEquals(7, business.calculateSumUsingDataService());
	}
	
	@Test
	void calculateSumEmptyArrayTest() {
		SomeBusinessService business = new SomeBusinessService();
		business.setDataService(new SomeDataServiceEmptyStub());
		assertEquals(0, business.calculateSumUsingDataService());
	}

}
