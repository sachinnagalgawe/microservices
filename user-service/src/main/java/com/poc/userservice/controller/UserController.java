package com.poc.userservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.commonlib.entity.User;
import com.poc.commonlib.service.UserService;

/**
 * User controller for all rest operations related to user
 */
@RestController
@RequestMapping("/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	/**
	 * User service
	 */
	@Autowired
	private UserService userService;

	/**
	 * Create user
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public User createUser(@RequestBody User user) {
		logger.info("Api call received to Create user");
		return userService.create(user);
	}

	/**
	 * Get user by userId
	 * 
	 * @param userId
	 * @return
	 */
	@GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public User getUserById(@PathVariable("userId") int userId) {
		logger.info("Api call received to get user by id: " + userId);
		return userService.findById(userId);
	}
	
	/**
	 * Get all users
	 * 
	 * @return
	 */
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllUsers() {
		logger.info("Api call received to get all users");
		return userService.findAll();
	}
	
	/**
	 * Update user by userid
	 * 
	 * @param userId
	 * @param user
	 * @return
	 */
	@PutMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public User updateUserById(@PathVariable("userId") int userId, @RequestBody User user) {
		logger.info("Api call received to update user by id: " + userId);
		return userService.updateById(userId, user);
	}
	
	/**
	 * Delete user by user id
	 * 
	 * @param userId
	 */
	@DeleteMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteUserById(@PathVariable("userId") int userId) {
		logger.info("Api call received to delete user by id: " + userId);
		userService.deleteById(userId);
	}
}
