package com.courseapp.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "course_table")
public class CourseTable implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int course_id;
	private String course_name;
	private String course_description;
	private String course_created_time;
	private String course_updated_time;
	private String user_name;
	private String author;

	@Enumerated(EnumType.STRING)
	private SkilLevel course_skil_level;

	@JsonIgnore
	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinTable(name = "course_user", joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "course_id"), inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "course_id"))
	private List<CourseUsers> registeredusers=new ArrayList<>();
	
	@OneToMany(mappedBy="course", cascade=CascadeType.ALL)
	private List<Topics> topics=new ArrayList<>();
	
	public CourseTable(String course_name, String course_description, SkilLevel course_skill_level,
			String course_created_time, String course_updated_time, String user_name, String author, int course_id) {
		super();
		this.course_name = course_name;
		this.course_description = course_description;
		this.course_skil_level = course_skill_level;
		this.course_created_time = course_created_time;
		this.course_updated_time = course_updated_time;
		this.user_name = user_name;
		this.author = author;
		this.course_id = course_id;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getCourse_description() {
		return course_description;
	}

	public void setCourse_description(String course_description) {
		this.course_description = course_description;
	}

	public SkilLevel getCourse_skil_level() {
		return course_skil_level;
	}

	public void setCourse_skil_level(SkilLevel course_skill_level) {
		this.course_skil_level = course_skill_level;
	}

	public String getCourse_created_time() {
		return course_created_time;
	}

	public void setCourse_created_time(String course_created_time) {
		this.course_created_time = course_created_time;
	}

	public String getCourse_updated_time() {
		return course_updated_time;
	}

	public void setCourse_updated_time(String course_updated_time) {
		this.course_updated_time = course_updated_time;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
