package org.filippo.formazione.springbootquickstart.courseapidata.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//In Spring i servizi sono spesso dei singletons
//Supponiamo quindi che in un controller venga richiesta un'istanza => Spring inietta SEMPRE la stessa istanza
@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	public List<Course> getAllCourses(String topicId) { 
		return this.courseRepository.findByTopicId(topicId);
	
	}
	
	public Course getCourse(String id) {
		
		return this.courseRepository.findOne(id);
	}

	public void addCourse(Course course) {
		this.courseRepository.save(course);
		
	}

	public void updateCourse(Course course) {
		this.courseRepository.save(course);
		
	}

	public void deleteCourse(String id) {
		this.courseRepository.delete(id);
		
	}
}
