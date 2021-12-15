package org.filippo.formazione.springbootquickstart.courseapidata.course;

import java.util.List;

import org.filippo.formazione.springbootquickstart.courseapidata.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	//Qui facciamo injection del businessService
	@Autowired
	private CourseService courseService;
	
	//Avendo annotato la classe come RestController Spring effettua in automatico la conversione
	//In Json della lista di oggetti
	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable String topicId) {
		return this.courseService.getAllCourses(topicId);
	}
	
	//Get a specific topic based on id that is the variable portion
	//To send it to the method as parameter
	@RequestMapping("/topics/{topicId}/courses/{courseId}")
	public Course getCourse(@PathVariable("topicId") String topicId, @PathVariable("courseId") String courseId) {
		return this.courseService.getCourse(courseId);
	}
	
	//Create a new resource using a POST
	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
	//Usando questa annotazione dico a Spring che la req body contiene una versione JSON
	//Dell'oggetto Topic
	public void addCourse(@PathVariable String topicId, @RequestBody Course course) {
		course.setTopic(new Topic(topicId, "", ""));
		this.courseService.addCourse(course);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{courseId}")
	public void updateCourse(@PathVariable String topicId, @PathVariable String courseId ,@RequestBody Course course) {
		course.setTopic(new Topic(topicId, "", ""));
		this.courseService.updateCourse(course);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{courseId}")
	public void deleteTopic(@PathVariable String courseId) {
		this.courseService.deleteCourse(courseId);
	}
	
}
