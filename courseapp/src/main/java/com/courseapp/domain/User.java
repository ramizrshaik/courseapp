package com.courseapp.domain;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Da Vinci's Deemon
 *
 */
@Entity
@Table(name = "user_table")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column
	private int userId;

	@Column
	@Id
	@Email(message = "Expecting email for user name")
	@NotBlank(message = "User name should not be empty")
	private String userName;

	@Column
	@NotBlank(message = "password field should not be left blank")
	@Pattern.List({ @Pattern(regexp = "(?=.*[0-9])", message = "Password must contain one digit."),
			@Pattern(regexp = "(?=.*[a-z])", message = "Password must contain one lowercase letter."),
			@Pattern(regexp = "(?=.*[a-z])", message = "Password must contain one lowercase letter."),
			@Pattern(regexp = "(?=\\S+$)", message = "Password must contain no whitespace.") })

	private String password;
	@Column
	private LocalTime userCreationTime;
	@Column
	private String userUpdatedTime;

	@JsonIgnore
	@ManyToMany(mappedBy = "registeredUsers")
	private List<Course> courses = new ArrayList<>();

	public User(int user_id, String user_name, String password, LocalTime user_creation_time, String user_updated_time) {
		super();
		this.userId = user_id;
		this.userName = user_name;
		this.password = password;
		this.userCreationTime = user_creation_time;
		this.userUpdatedTime = user_updated_time;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + userId;
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
		User other = (User) obj;
		if (userId != other.userId)
			return false;
		return true;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "User [user_id=" + userId + "]";
	}

	public int getUser_id() {
		return userId;
	}

	public void setUser_id(int user_id) {
		this.userId = user_id;
	}

	public String getUser_name() {
		return userName;
	}

	public void setUser_name(String user_name) {
		this.userName = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalTime getUser_creation_time() {
		return userCreationTime;
	}

	public void setUser_creation_time(LocalTime user_creation_time) {
		this.userCreationTime = user_creation_time;
	}

	public String getUser_updated_time() {
		return userUpdatedTime;
	}

	public void setUser_updated_time(String user_updated_time) {
		this.userUpdatedTime = user_updated_time;
	}

}
