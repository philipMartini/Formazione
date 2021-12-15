package org.filippo.formazione.springbootquickstart.courseapidata.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	//Qui facciamo injection del businessService
	@Autowired
	private TopicService topicService;
	
	//Avendo annotato la classe come RestController Spring effettua in automatico la conversione
	//In Json della lista di oggetti
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return this.topicService.getAllTopics();
	}
	
	//Get a specific topic based on id that is the variable portion
	//To send it to the method as parameter
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable("id") String id) {
		return this.topicService.getTopic(id);
	}
	
	//Create a new resource using a POST
	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	//Usando questa annotazione dico a Spring che la req body contiene una versione JSON
	//Dell'oggetto Topic
	public void addTopic(@RequestBody Topic topic) {
		this.topicService.addTopic(topic);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		this.topicService.updateTopic(id, topic);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		this.topicService.deleteTopic(id);
	}
	
}
