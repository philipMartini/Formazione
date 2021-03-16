package stockItem;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
	
	private final Map<String, StockItem> items;
	
	public StockList(){
		this.items = new LinkedHashMap<>();
	}
	
	public int addStock(StockItem item){
		if(item != null){
			StockItem inStock = this.items.getOrDefault(item.getName(), item);
			if(inStock != item){
				item.adjustQuantityStock(inStock.getQuantityStock());
			}
			
			this.items.put(item.getName(), item);
			return item.getQuantityStock();
		}
		
		return 0;
	}
	
	public int sellStock(String item, int quantity){
		StockItem inStock = this.items.get(item);
		if(inStock != null && quantity > 0)
			return inStock.finaliseStock(quantity);
		return 0;
	}
	
	
	public int reserveStock(String item, int quantity){
		StockItem inStock = this.items.get(item);
		if(inStock != null && quantity > 0){
			return inStock.reserveStock(quantity);
		}
		return 0;
	}
	
	public int unreserveStock(String item, int quantity){
		StockItem inStock = this.items.get(item);
		if(inStock != null && quantity > 0){
			return inStock.unreserveStock(quantity);
		}
		return 0;
	}
	
	public StockItem get(String key){
		return this.items.get(key);
	}
	
	public Map<String, StockItem> getItems(){
		/*Attenzione La map è immutabile(No aggiunta, rimozione) 
		 * MA gli oggetti interni POSSONO ESSERE MODIFICATI*/
		return Collections.unmodifiableMap(this.items);
	} 
	
	/*I questo caso se non vogliamo dare la possibilità di modificare gli oggetti ha senso
	 * Scrivere un metodo di questo tipo, senza returnare gli oggetti*/
	public Map<String, Double> priceList(){
		Map<String, Double> result = new LinkedHashMap<>();
		for(Map.Entry<String, StockItem> e : this.items.entrySet()){
			result.put(e.getKey(), e.getValue().getPrice());
		}
		
		return Collections.unmodifiableMap(result);
	}
	
	@Override
	public String toString(){
		String s = "StockList:\n";
		
		for (Map.Entry<String, StockItem> item : this.items.entrySet()){
			s += "\t" + item.getValue().toString() + "\n";
		}
		
		return s;
	}

}
