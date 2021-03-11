package com.poc.commonlib.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.poc.commonlib.entity.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, Integer> {

	public Cart findOneById(Integer cartId);

	public Cart findOneByUserId(Integer userId);

}
