package com.courseapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courseapp.domain.Course;
import com.courseapp.domain.Topic;
import com.courseapp.domain.User;
import com.courseapp.repositories.CourseRepository;
import com.courseapp.repositories.UserRepository;

/*first apply @valid annotation for the object to be validated
go to domain class apply validation annotations like notnull,past,length, pattern,email
create a custom class which tells client what the errors are
you need to know what exception spring throws when validation fails
for that exception we need to define an exception handler which goes to controller advice class*/


@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Course saveCourse(Course course) throws Exception {
		return courseRepository.save(course);
	}
	
	public Course getCourseById(int courseId) throws Exception{
		return courseRepository.findOne(courseId);
	}
	
	public void deleteCourse(int courseId) throws Exception{
		Course course=courseRepository.findOne(courseId);
		if(course==null){
			throw new Exception("course not found ");
			
		}
		courseRepository.delete(course);
	}
	
	public Course addUserToCourse(int courseId, String userId) throws Exception{
		Course course=getCourseById(courseId);
		User user = userRepository.findOne(userId);
		course.getRegisteredusers().add(user);
		return courseRepository.save(course);
	}
	
	public Course removeUserFromCourse(int courseId, String userId) throws Exception{
		Course course=getCourseById(courseId);
		User user = userRepository.findOne(userId);
		course.getRegisteredusers().remove(user);
		return courseRepository.save(course);
	}
	
	public Course addTopicToCourse(Integer courseId, Topic topic) throws Exception {
		Course course=getCourseById(courseId);
		course.getTopics().add(topic);
		return courseRepository.save(course);
		
	}
	
	public Course removeTopicFromCourse(Integer courseId, Topic topic) throws Exception {
		Course course=getCourseById(courseId);
		course.getTopics().remove(topic);
		return courseRepository.save(course);
		
	}
	
}
