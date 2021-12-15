package org.filippo.formazione.springbootquickstart.courseapidata.lesson;

import java.util.List;

import org.filippo.formazione.springbootquickstart.courseapidata.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class LessonService {
	
	@Autowired
	private LessonRepository lessonRepository;
	
	
	public List<Lesson> getLessonsByCourse(String courseId) {
		return this.lessonRepository.findByCourseId(courseId);
		
	}


	public Lesson getLesson(String courseId, int lessonId) {
		List<Lesson> lessons = this.lessonRepository.findByCourseId(courseId);
		for(Lesson l : lessons) {
			if(lessonId == l.getLessonNumber())
				return l;
		}
		return null;
	}


	public void addLesson(Lesson lesson) {
		this.lessonRepository.save(lesson);
		
	}


	public void updateLesson(Lesson lesson) {
		this.lessonRepository.save(lesson);
		
	}




	public void deleteLesson(String courseId, int lessonId) {
		List<Lesson> lessons = this.getLessonsByCourse(courseId);
		for(Lesson l : lessons) {
			if(l.getLessonNumber() == lessonId)
				this.lessonRepository.delete(l.getId());
		}
		
	}
	
	
}
