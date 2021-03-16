package stockItem;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Basket {
	
	private final String name;
	private final Map<StockItem, Integer> list;
	
	public Basket(String name) {
		this.name = name;
		this.list = new TreeMap<StockItem, Integer>();
	}
	
	public int addToBasket(StockItem item, int quantity){
		if(item != null && quantity > 0){
			int inBasket = list.getOrDefault(item, 0);
			list.put(item, inBasket + quantity);
			return inBasket;
		}
		
		return 0;
	}
	
	
	public int removeFromBasket(StockItem item, int quantity){
		if(item != null && quantity > 0){
			int inBasket = this.list.getOrDefault(item, 0);
			int newQuantity = inBasket - quantity;
			
			if(newQuantity > 0 ){
				this.list.put(item, newQuantity);
				return quantity;
			}else if(newQuantity == 0){ this.list.remove(item); return quantity;}
		}
		return 0;
	}
	
	public void clearBasket(){ this.list.clear(); }
	
	
	public Map<StockItem, Integer> items(){
		return Collections.unmodifiableMap(this.list);
	}

	@Override
	public String toString() {
		String result =  "Basket " + this.name + " contains " + list.size() + ((this.list.size() == 1) ? " item": " items") + "\n";
		double totalCost = 0.0;
		for(Map.Entry<StockItem, Integer> item : this.list.entrySet()){
			result += item.getKey() + " Quantity purchased: " + item.getValue() + "\n";
			totalCost += item.getKey().getPrice() * item.getValue();
		}
		
		
		return result + "\n TOTAL COST: " + totalCost;
	}
	
	
}
