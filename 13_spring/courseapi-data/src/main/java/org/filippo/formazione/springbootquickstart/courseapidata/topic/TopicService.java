package org.filippo.formazione.springbootquickstart.courseapidata.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//In Spring i servizi sono spesso dei singletons
//Supponiamo quindi che in un controller venga richiesta un'istanza => Spring inietta SEMPRE la stessa istanza
@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
//	private List<Topic> topics = new ArrayList<>(Arrays.asList(
//			new Topic("Spring", "Spring Framework", "Spring Framework Description"),
//			new Topic("Java", "Core Java", "Core Java Description"),
//			new Topic("Javascript", "Javascript", "Javascript Description"))
//			);
	
	public List<Topic> getAllTopics() { 
		List<Topic> topics = new ArrayList<>();
		this.topicRepository.findAll().forEach(topics::add);
		return topics;
	
	}
	
	public Topic getTopic(String id) {
		
		return this.topicRepository.findOne(id);
	}

	public void addTopic(Topic topic) {
		this.topicRepository.save(topic);
		
	}

	public void updateTopic(String id, Topic topic) {
		this.topicRepository.save(topic);
		
	}

	public void deleteTopic(String id) {
		this.topicRepository.delete(id);
		
	}
}
