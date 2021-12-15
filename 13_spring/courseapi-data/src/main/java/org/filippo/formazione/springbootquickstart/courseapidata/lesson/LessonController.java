package org.filippo.formazione.springbootquickstart.courseapidata.lesson;

import java.util.List;

import org.filippo.formazione.springbootquickstart.courseapidata.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LessonController {
	
	@Autowired
	private LessonService lessonService;
	
	@RequestMapping("/topics/{topicId}/courses/{courseId}/lessons")
	public List<Lesson> getLessonsForCourse(@PathVariable String courseId){
		return this.lessonService.getLessonsByCourse(courseId);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
	public Lesson getLesson(@PathVariable String courseId, @PathVariable int lessonId) {
		
		return this.lessonService.getLesson(courseId, lessonId);
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses/{courseId}/lessons")
	public void addLesson(@PathVariable String courseId, @RequestBody Lesson lesson){
		lesson.setCourse(new Course(courseId, "", "", ""));
		this.lessonService.addLesson(lesson);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
	public void updateLesson(@PathVariable String courseId, @RequestBody Lesson lesson){
		lesson.setCourse(new Course(courseId, "", "", ""));
		this.lessonService.updateLesson(lesson);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
	public void deleteLesson(@PathVariable String courseId, @PathVariable int lessonId){
		
		this.lessonService.deleteLesson(courseId, lessonId);
	}
	
	
	
}
