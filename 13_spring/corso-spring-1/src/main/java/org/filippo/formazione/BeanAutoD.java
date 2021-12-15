package org.filippo.formazione;

public class BeanAutoD {
	
	private BeanAutoC bean;
	
	public String hello() {
		return "Hello From BeanAuto D " + this.bean.hello();
	}

	public BeanAutoC getBean() {
		return bean;
	}

	public void setBean(BeanAutoC bean) {
		this.bean = bean;
	}
	
	
}
