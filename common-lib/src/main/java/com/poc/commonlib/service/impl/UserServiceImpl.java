package com.poc.commonlib.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.poc.commonlib.entity.User;
import com.poc.commonlib.repository.UserRepository;
import com.poc.commonlib.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User create(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findById(Integer id) {
		return userRepository.findOneById(id);
	}

	@Override
	public User updateById(Integer id, User user) {
		User existingUser = this.findById(id);
		if (user != null) {
			if (!StringUtils.isEmpty(user.getUserName())) {
				existingUser.setUserName(user.getUserName());
			}
			if (!StringUtils.isEmpty(user.getEmail())) {
				existingUser.setEmail(user.getEmail());
			}
			if (!StringUtils.isEmpty(user.getPassword())) {
				existingUser.setPassword(user.getPassword());
			}
			return userRepository.save(existingUser);
		}
		return null;
	}

	@Override
	public void deleteById(Integer id) {
		userRepository.deleteById(id);
	}
}
