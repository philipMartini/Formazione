package org.filippo.formazione.unittesting.business;

import org.filippo.formazione.unittesting.data.SomeDataService;

public class SomeBusinessService {
	
	private SomeDataService dataService;
	
	public void setDataService(SomeDataService dataService) {
		this.dataService = dataService;
	}

	public int calculateSum(int[] data) {
		int sum = 0;
		for(int value : data)
			sum += value;
		return sum;
	}
	
	public int calculateSumUsingDataService() {
		int sum = 0;
		int[] data = this.dataService.retriveAllData();
		for(int value : data)
			sum += value;
		
		
		return sum;
	}
}
