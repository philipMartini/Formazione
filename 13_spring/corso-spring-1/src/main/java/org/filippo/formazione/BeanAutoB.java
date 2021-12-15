package org.filippo.formazione;

public class BeanAutoB {
	
	private BeanAutoA autoA;
	private BeanAutoC autoC;
	
	public String hello() {
		return "Hello From AutoBean B " + this.autoA.hello() + " " + this.autoC.hello();
	}

	public BeanAutoA getAutoA() {
		return autoA;
	}

	public void setAutoA(BeanAutoA autoA) {
		this.autoA = autoA;
	}

	public BeanAutoC getAutoC() {
		return autoC;
	}

	public void setAutoC(BeanAutoC autoC) {
		this.autoC = autoC;
	}
	
	
	
}
