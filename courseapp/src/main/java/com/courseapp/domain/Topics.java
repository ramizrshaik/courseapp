package com.courseapp.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "topics")
public class Topics implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long topic_id;
	private String course_id;
	private String topic_name;
	private String topic_duration;

	public Topics(int topic_id, String course_id, String topic_name, String topic_duration) {
		super();
		this.topic_id = topic_id;
		this.course_id = course_id;
		this.topic_name = topic_name;
		this.topic_duration = topic_duration;
	}

	public long getTopic_id() {
		return topic_id;
	}

	public void setTopic_id(int topic_id) {
		this.topic_id = topic_id;
	}

	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	public String getTopic_name() {
		return topic_name;
	}

	public void setTopic_name(String topic_name) {
		this.topic_name = topic_name;
	}

	public String getTopic_duration() {
		return topic_duration;
	}

	public void setTopic_duration(String topic_duration) {
		this.topic_duration = topic_duration;
	}

}
