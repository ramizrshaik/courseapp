package com.courseapp.domain;

import java.io.Serializable;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Topics")
public class Topic implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private long topicId;
	@Column
	private String courseId;
	@Column
	private String topicName;
	@Column
	private LocalTime topicDuration;
	
	@ManyToOne
	@JoinColumn(name="course_id")
	private Course course;

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Topic(int topic_id, String course_id, String topic_name, LocalTime topic_duration) {
		super();
		this.topicId = topic_id;
		this.courseId = course_id;
		this.topicName = topic_name;
		this.topicDuration = topic_duration;
	}

	public long getTopic_id() {
		return topicId;
	}

	public void setTopic_id(int topic_id) {
		this.topicId = topic_id;
	}

	public String getCourse_id() {
		return courseId;
	}

	public void setCourse_id(String course_id) {
		this.courseId = course_id;
	}

	public String getTopic_name() {
		return topicName;
	}

	public void setTopic_name(String topic_name) {
		this.topicName = topic_name;
	}

	public LocalTime getTopic_duration() {
		return topicDuration;
	}

	public void setTopic_duration(LocalTime topic_duration) {
		this.topicDuration = topic_duration;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (topicId ^ (topicId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Topic other = (Topic) obj;
		if (topicId != other.topicId)
			return false;
		return true;
	}
	
	

}
