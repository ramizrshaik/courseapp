package com.courseapp.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "course_users")
public class CourseUsers implements Serializable {

	private static final long serialVersionUID = 1L;

	private int course_id;
	private int user_id;

	public CourseUsers(int course_id, int user_id) {
		super();
		this.course_id = course_id;
		this.user_id = user_id;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

}
