package org.filippo.formazione.springbootquickstart.courseapidata.topic;

import org.springframework.data.repository.CrudRepository;

//Tutti dataLayer contengono di fatto operazioni comuni per tutte le entities
//Quindi spring astrae tali operazioni nell'interfaccia CrudRepository
//A te non resta che implementare metodi che hanno particolari esigenze
//I tipi generici sono la classe della Entity e il tipo della PK
public interface TopicRepository extends CrudRepository<Topic, String>{
	
	
	
	
}
