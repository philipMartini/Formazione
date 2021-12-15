package org.filippo.formazione.unittesting.controller;

import java.util.List;

import org.filippo.formazione.unittesting.business.ItemBusinessService;
import org.filippo.formazione.unittesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
	
	@Autowired
	private ItemBusinessService service;

	@GetMapping(path = "/dummy-item")
	public Item getItem() {
		return new Item(1, "Ball", 3, 7);
	}
	
	@GetMapping(path = "/item-from-business-service")
	public Item getItemFromBusinessService() {
		return this.service.retriveHarcodedItem();
	}
	
	@GetMapping(path = "/all-items-from-db")
	public List<Item> retriveAllItems(){
		return this.service.retriveAllItems();
	}
	
}
