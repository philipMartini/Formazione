package org.filippo.formazione.unittesting.business;




import java.util.List;

import org.filippo.formazione.unittesting.data.ItemRepository;
import org.filippo.formazione.unittesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemBusinessService {
	
	@Autowired
	private ItemRepository repository;
	
	
	public Item retriveHarcodedItem() {
		// TODO Auto-generated method stub
		return new Item(1, "Ball", 3, 7);
	}
	
	public List<Item> retriveAllItems(){
		List<Item> items = this.repository.findAll();
		//Business logic
		for(Item item : items) {
			item.setValue(item.getPrice() * item.getQuantity());
		}
		
		return items;
	}	

}
