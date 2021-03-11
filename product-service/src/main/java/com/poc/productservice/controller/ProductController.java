package com.poc.productservice.controller;

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

import com.poc.commonlib.entity.Product;
import com.poc.commonlib.service.ProductService;

/**
 * Product controller for all rest operations related to Product
 */
@RestController
@RequestMapping("/product")
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	/**
	 * Product service
	 */
	@Autowired
	private ProductService productService;

	/**
	 * Create product
	 * 
	 * @param product
	 * @return
	 */
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Product createProduct(@RequestBody Product product) {
		logger.info("Api call received to Create Product");
		return productService.create(product);
	}

	/**
	 * Get all products
	 * 
	 * @return
	 */
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> getAllProducts() {
		logger.info("Api call received to get all Products");
		return productService.findAll();
	}

	/**
	 * Get product by id
	 * 
	 * @param productId
	 * @return
	 */
	@GetMapping(value = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Product getProductById(@PathVariable("productId") int productId) {
		logger.info("Api call received to get Product by id: " + productId);
		return productService.findById(productId);
	}
	
	/**
	 * Update product by id
	 * 
	 * @param productId
	 * @param product
	 * @return
	 */
	@PutMapping(value = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Product updateProductById(@PathVariable("productId") int productId, @RequestBody Product product) {
		logger.info("Api call received to update Product by id: " + productId);
		return productService.updateById(productId, product);
	}
	
	/**
	 * Delete product by id
	 * 
	 * @param productId
	 */
	@DeleteMapping(value = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteProductById(@PathVariable("productId") int productId) {
		logger.info("Api call received to delete Product by id: " + productId);
		productService.deleteById(productId);
	}
}
