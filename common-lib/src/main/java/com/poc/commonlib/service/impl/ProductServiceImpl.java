package com.poc.commonlib.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.poc.commonlib.entity.Product;
import com.poc.commonlib.repository.ProductRepository;
import com.poc.commonlib.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product create(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product findById(int productId) {
		return productRepository.findOneById(productId);
	}

	@Override
	public List<Product> findAll() {
		return (List<Product>) productRepository.findAll();
	}

	@Override
	public Product updateById(int productId, Product product) {
		Product existingProduct = this.findById(productId);
		if (product != null) {
			if (!StringUtils.isEmpty(product.getName())) {
				existingProduct.setName(product.getName());
			}
			if (product.getPrice() != null) {
				existingProduct.setPrice(product.getPrice());
			}
			if (product.getQuantity() != null) {
				existingProduct.setQuantity(product.getQuantity());
			}
			return productRepository.save(existingProduct);
		}
		return null;

	}

	@Override
	public void deleteById(int productId) {
		productRepository.deleteById(productId);
	}

}
