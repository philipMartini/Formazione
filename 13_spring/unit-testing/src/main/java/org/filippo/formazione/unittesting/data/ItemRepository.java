package org.filippo.formazione.unittesting.data;


import org.filippo.formazione.unittesting.model.Item;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepository extends JpaRepository<Item, Integer> {

	
}
