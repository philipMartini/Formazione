package org.advancia.filippo.model;

public class CoffeeBean {
	
	private String coffeeName;
	private double price;
	private int quantity;
	private String suppName;

	public CoffeeBean() {
		// TODO Auto-generated constructor stub
	}

	public CoffeeBean(String coffeeName, double price, int quantity) {
		super();
		this.coffeeName = coffeeName;
		this.price = price;
		this.quantity = quantity;
		this.suppName = "";
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
	
	public String getSuppName() { return this.suppName; } 
	
	public void setSuppName(String suppName) {
		this.suppName = suppName;
		
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coffeeName == null) ? 0 : coffeeName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CoffeeBean other = (CoffeeBean) obj;
		if (coffeeName == null) {
			if (other.coffeeName != null)
				return false;
		} else if (!coffeeName.equals(other.coffeeName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CoffeeBean [coffeeName=" + coffeeName + ", price=" + price + ", quantity=" + quantity + "]";
	}

	
	
	

}
