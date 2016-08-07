package com.courseapp.domain;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity // if we declare a class as an "entity" means it represents a class in
		// the database
@Table(name = "course_table")
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id // represents the primary key in the database table
	@GeneratedValue(strategy = GenerationType.AUTO) // auto increments the
													// primary key value
	@NotEmpty
	@Size(min=4, max=8, message="enter valid course id") //JPA validation
	private int courseId;
	
	@Column
	@NotEmpty
	private String courseName;
	@Column
	private String courseDescription;
	@Column
	private LocalTime courseCreatedTime;
	@Column
	private LocalTime courseUpdatedTime;
	@Column
	private String userName;
	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	@Column
	private String author;

	@Column
	@Enumerated(EnumType.STRING)
	private SkilLevel course_skil_level;

	@JsonIgnore
	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinTable(name = "course_user", joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "course_id"), inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_name"))
	private List<User> registeredusers = new ArrayList<>();

	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private List<Topic> topics = new ArrayList<>();

	public Course(String course_name, String course_description, SkilLevel course_skill_level,
			LocalTime course_created_time, LocalTime course_updated_time, String user_name, String author,
			int course_id) {
		super();
		this.courseName = course_name;
		this.courseDescription = course_description;
		this.course_skil_level = course_skill_level;
		this.courseCreatedTime = course_created_time;
		this.courseUpdatedTime = course_updated_time;
		this.userName = user_name;
		this.author = author;
		this.courseId = course_id;
	}

	public int getCourse_id() {
		return courseId;
	}

	public void setCourse_id(int course_id) {
		this.courseId = course_id;
	}

	public String getCourse_name() {
		return courseName;
	}

	public void setCourse_name(String course_name) {
		this.courseName = course_name;
	}

	public String getCourse_description() {
		return courseDescription;
	}

	public void setCourse_description(String course_description) {
		this.courseDescription = course_description;
	}

	public SkilLevel getCourse_skil_level() {
		return course_skil_level;
	}

	public void setCourse_skil_level(SkilLevel course_skill_level) {
		this.course_skil_level = course_skill_level;
	}

	public LocalTime getCourse_created_time() {
		return courseCreatedTime;
	}

	public void setCourse_created_time(LocalTime course_created_time) {
		this.courseCreatedTime = course_created_time;
	}

	public LocalTime getCourse_updated_time() {
		return courseUpdatedTime;
	}

	public void setCourse_updated_time(LocalTime course_updated_time) {
		this.courseUpdatedTime = course_updated_time;
	}

	public String getUser_name() {
		return userName;
	}

	public void setUser_name(String user_name) {
		this.userName = user_name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public List<User> getRegisteredusers() {
		return registeredusers;
	}

	public void setRegisteredusers(List<User> registeredusers) {
		this.registeredusers = registeredusers;
	}

}
