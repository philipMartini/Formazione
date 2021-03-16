package stockItem;

import java.util.Map;

public class Main {
	
	private static StockList stockList = new StockList();

	public static void main(String[] args) {
		 StockItem temp = new StockItem("bread", 0.86, 100);
	        stockList.addStock(temp);

	        temp = new StockItem("cake", 1.10, 7);
	        stockList.addStock(temp);

	        temp = new StockItem("car", 12.50, 2);
	        stockList.addStock(temp);

	        temp = new StockItem("chair", 62.0, 10);
	        stockList.addStock(temp);

	        temp = new StockItem("cup", 0.50, 200);
	        stockList.addStock(temp);

	        temp = new StockItem("door", 72.95, 4);
	        stockList.addStock(temp);

	        temp = new StockItem("juice", 2.50, 36);
	        stockList.addStock(temp);

	        temp = new StockItem("phone", 96.99, 35);
	        stockList.addStock(temp);

	        temp = new StockItem("towel", 2.40, 80);
	        stockList.addStock(temp);

	        temp = new StockItem("vase", 8.76, 40);
	        stockList.addStock(temp);

	        System.out.println(stockList);

	        for(String s: stockList.getItems().keySet()) {
	            System.out.println(s);
	        }

	      Basket philBasket = new Basket("Phil");
	      sellItem(philBasket, "car", 1);
	      System.out.println(philBasket);
	      sellItem(philBasket, "car", 1);
	      System.out.println(philBasket);
	      sellItem(philBasket, "car", 1);
	      sellItem(philBasket, "var", 5);
	      sellItem(philBasket, "juice", 4);
	      sellItem(philBasket, "cup", 12);
	      sellItem(philBasket, "bread", 1);
	      System.out.println(philBasket);
	      
	     for(Map.Entry<String, Double> e : stockList.priceList().entrySet()){
	    	 System.out.println("Item Name: " + e.getKey() + " Item price: " + e.getValue());
	     }
	}

	
	public static int sellItem(Basket basket, String item, int quantity){
		StockItem stockItem = stockList.get(item);
		if(stockItem == null){
			System.out.println("We don't sell " + item);
			return 0;
		}
		
		if(stockList.reserveStock(item, quantity) != 0){
			return basket.addToBasket(stockItem, quantity);
		}
		return 0;
	}
	
	
	public static int removeItem(Basket basket, String item, int quantity){
		StockItem stockItem = stockList.get(item);
		if(stockItem == null){
			System.out.println("We don't sell " + item);
			return 0;
		}
		
		if(basket.removeFromBasket(stockItem, quantity) == quantity){
			return stockList.unreserveStock(item, quantity);
		}
		return 0;
	}
	
	
	public static void checkout(Basket basket){
		for(Map.Entry<StockItem, Integer> item : basket.items().entrySet()){
			stockList.sellStock(item.getKey().getName(),item.getValue());
		}
		basket.clearBasket();
	}
}
