package com.poc.commonlib.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.poc.commonlib.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	public List<User> findAll();

	public User findOneById(Integer id);
}
