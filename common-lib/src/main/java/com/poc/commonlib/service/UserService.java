package com.poc.commonlib.service;

import java.util.List;

import com.poc.commonlib.entity.User;

public interface UserService {

	public User create(User user);

	public List<User> findAll();

	public User findById(Integer id);

	public User updateById(Integer id, User user);

	public void deleteById(Integer id);
}
