package org.filippo.formazione.unittesting.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.filippo.formazione.unittesting.model.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class ItemRepositoryTest {
	
	@Autowired
	private ItemRepository repository;
	
	//Se ci fosse dietro un vero db, potrei mettere un data.sql in /test/resources
	//Per popolare un db in memoria e usarlo solo ai fini di testing
	@Test
	void findAllTest() {
		List<Item> items = this.repository.findAll();
		assertEquals(3, items.size());
	}

}
