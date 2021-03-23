package org.advancia.filippo.model;

public class CoffeeBean {
	
	private String coffeeName;
	private double price;
	private int quantity;

	public CoffeeBean() {
		// TODO Auto-generated constructor stub
	}

	public CoffeeBean(String coffeeName, double price, int quantity) {
		super();
		this.coffeeName = coffeeName;
		this.price = price;
		this.quantity = quantity;
	}

	public String getCoffeeName() {
		return coffeeName;
	}

	public void setCoffeeName(String coffeeName) {
		this.coffeeName = coffeeName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
