package com.poc.commonlib.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.poc.commonlib.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

	public Product findOneById(Integer productId);
}
