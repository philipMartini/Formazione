package org.filippo.formazione.springbootquickstart.courseapidata.lesson;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.filippo.formazione.springbootquickstart.courseapidata.course.Course;

@Entity
public class Lesson {
	
	@Id
	private int id;
	private int lessonNumber;
	private String description;
	@ManyToOne
	private Course course;
	
	
	
	public Lesson() {}
	
	
	public Lesson(int id, int lessonNumber, String description, String courseId) {
		super();
		this.id = id;
		this.lessonNumber = lessonNumber;
		this.description = description;
		this.course = new Course(courseId, "", "", "");
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLessonNumber() {
		return lessonNumber;
	}
	public void setLessonNumber(int lessonNumber) {
		this.lessonNumber = lessonNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	
	
	
}
