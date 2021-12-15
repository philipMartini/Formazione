package org.filippo.formazione.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

//In Spring i servizi sono spesso dei singletons
//Supponiamo quindi che in un controller venga richiesta un'istanza => Spring inietta SEMPRE la stessa istanza
@Service
public class TopicService {
	
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("Spring", "Spring Framework", "Spring Framework Description"),
			new Topic("Java", "Core Java", "Core Java Description"),
			new Topic("Javascript", "Javascript", "Javascript Description"))
			);
	
	public List<Topic> getAllTopics() { return this.topics; }
	
	public Topic getTopic(String id) {
		
		return this.topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		this.topics.add(topic);
		
	}

	public void updateTopic(String id, Topic topic) {
		for(int i = 0; i < this.topics.size(); ++i) {
			if(this.topics.get(i).getId().equals(id)) {
				this.topics.set(i, topic);
				return;
			}
		}
		
	}

	public void deleteTopic(String id) {
		for(int i = 0; i < this.topics.size(); ++i) {
			if(this.topics.get(i).getId().equals(id)) {
				this.topics.remove(i);
				return;
			}
		}
		
	}
}
