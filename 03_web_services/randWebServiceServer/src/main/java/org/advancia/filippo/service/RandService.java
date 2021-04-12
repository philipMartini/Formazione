package org.advancia.filippo.service;

import java.util.Random;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class RandService {
	
	public static final int maxRands = 16;
	
	@WebMethod
	public int next1() { return new Random().nextInt(); }
	
	@WebMethod
	public int[] nextN(final int n) {
		int [] result = null;
		if(n < maxRands) {
			result = new int[n];
			Random rand = new Random();
			for(int i = 0; i < n; ++i)
				result[i] = rand.nextInt();
		}
		return result;
	}
}
