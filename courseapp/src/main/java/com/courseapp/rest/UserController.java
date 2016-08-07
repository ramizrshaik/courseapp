package com.courseapp.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.courseapp.domain.Course;
import com.courseapp.domain.User;
import com.courseapp.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	// create user
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> create(@Valid @RequestBody User user) throws Exception {
		return new ResponseEntity<User>(userService.save(user), HttpStatus.CREATED);
	}

	// update user
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<User> update(@Valid @RequestBody User user) throws Exception {
		return new ResponseEntity<User>(userService.save(user), HttpStatus.OK);
	}

	// delete user
	@RequestMapping(value = "{userName}", method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> delete(@PathVariable("userName") String userName) throws Exception {
		if (!userName.contains(".com")) {
			userName += ".com";
		}

		userService.delete(userName);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	// get user by userName
	@RequestMapping(value = "{userName}", method = RequestMethod.GET)
	public ResponseEntity<User> getByUserName(@PathVariable("userName") String userName) throws Exception {
		if (!userName.contains(".com")) {
			userName += ".com";
		}

		return new ResponseEntity<User>(userService.findUserByName(userName), HttpStatus.OK);
	}

	// get all courses for a user
	@RequestMapping(value = "/courses/{userName}", method = RequestMethod.GET)
	public ResponseEntity<List<Course>> getAllCoursesForaUser(@PathVariable("userName") String userName)
			throws Exception {
		if (!userName.contains(".com")) {
			userName += ".com";
		}
		return new ResponseEntity<List<Course>>(userService.findUserByName(userName).getCourses(), HttpStatus.OK);
	}

}
