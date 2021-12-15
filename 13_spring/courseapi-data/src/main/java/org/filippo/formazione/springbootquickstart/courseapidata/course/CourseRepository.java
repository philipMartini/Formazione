package org.filippo.formazione.springbootquickstart.courseapidata.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//Tutti dataLayer contengono di fatto operazioni comuni per tutte le entities
//Quindi spring astrae tali operazioni nell'interfaccia CrudRepository
//A te non resta che implementare metodi che hanno particolari esigenze
//I tipi generici sono la classe della Entity e il tipo della PK
public interface CourseRepository extends CrudRepository<Course, String>{
	
	
	//Trova tutti i corsi associati ad un certo topicId
	//Ossia un metodo find custom
	//Il concetto è che il nome del metodo deve essere findBy{property}{subProperty}{...}
	public List<Course> findByTopicId(String topicId);
	
}
