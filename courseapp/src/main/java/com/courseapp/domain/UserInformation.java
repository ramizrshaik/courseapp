package com.courseapp.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_table")
public class UserInformation implements Serializable {

	private static final long serialVersionUID = 1L;

	private int user_id;
	private String user_name;
	private String password;
	private String user_creation_time;
	private String user_updated_time;

	public UserInformation(int user_id, String user_name, String password, String user_creation_time,
			String user_updated_time) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.password = password;
		this.user_creation_time = user_creation_time;
		this.user_updated_time = user_updated_time;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser_creation_time() {
		return user_creation_time;
	}

	public void setUser_creation_time(String user_creation_time) {
		this.user_creation_time = user_creation_time;
	}

	public String getUser_updated_time() {
		return user_updated_time;
	}

	public void setUser_updated_time(String user_updated_time) {
		this.user_updated_time = user_updated_time;
	}

}
