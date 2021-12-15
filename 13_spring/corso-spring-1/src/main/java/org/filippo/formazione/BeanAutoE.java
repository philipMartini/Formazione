package org.filippo.formazione;

public class BeanAutoE {
	
	private BeanAutoC bean;
	
	
	
	public BeanAutoE(BeanAutoC bean) {
		super();
		this.bean = bean;
	}



	public String hello() {
		return "Hello From AutoBean E " + this.bean.hello();
	}

	
	
}
