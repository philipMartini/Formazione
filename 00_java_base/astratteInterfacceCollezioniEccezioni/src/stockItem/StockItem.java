package stockItem;

public class StockItem implements Comparable{
	
	private final String name;
	private double price;
	private int quantityStock;
	private int reserved;
	
	

	public StockItem(String name, double price) {
		this.name = name;
		this.price = price;
		this.quantityStock = 0;
		this.reserved = 0;
	}
	
	
	public StockItem(String name, double price, int quantityStock) {
		super();
		this.name = name;
		this.price = price;
		this.quantityStock = quantityStock;
	}




	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}


	public int getQuantityStock() {
		return quantityStock - reserved;
	}

	public void setPrice(double price) {
		//Serve un minimo di checks
		this.price = price;
	}

	public void adjustQuantityStock(int quantity) {
		this.quantityStock += quantity;
	}
	
	public int reserveStock(int quantity){
		if(quantity <= this.getQuantityStock()){
			this.reserved += quantity;
			return quantity;
		}
		return 0;
	}
	
	public int unreserveStock(int quantity){
		if(quantity <= this.reserved){
			reserved -= quantity;
			return quantity;
		}
		return 0;
	}
	
	public int finaliseStock(int quantity){
		if(quantity <= this.reserved){
			this.quantityStock -= quantity;
			this.reserved -= quantity;
			return quantity;
		}
		
		return 0;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		StockItem other = (StockItem) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	



	@Override
	public String toString() {
		return "StockItem [name=" + name + ", price=" + price + ", quantityStock=" + 
	quantityStock + "+, reserved "+ this.reserved + "]";
	}


	@Override
	public int compareTo(Object o) {
		if(o != null){
			return this.name.compareTo(((StockItem)o).getName());
		}
		
		throw new NullPointerException();
	}

}
