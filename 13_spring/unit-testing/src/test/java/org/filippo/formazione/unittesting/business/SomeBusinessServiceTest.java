package org.filippo.formazione.unittesting.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SomeBusinessServiceTest {
	


	@Test
	void calculateSumBasicTest() {
		SomeBusinessService business = new SomeBusinessService();
		assertEquals(7, business.calculateSum(new int[] {5, 1, 1}));
	}
	
	@Test
	void calculateSumEmptyArrayTest() {
		SomeBusinessService business = new SomeBusinessService();
		assertEquals(0, business.calculateSum(new int[] {}));
	}

}
