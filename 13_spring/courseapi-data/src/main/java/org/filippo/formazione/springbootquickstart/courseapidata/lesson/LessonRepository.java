package org.filippo.formazione.springbootquickstart.courseapidata.lesson;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LessonRepository extends CrudRepository<Lesson, Integer>{

	List<Lesson> findByCourseId(String courseId);
	
	
}
