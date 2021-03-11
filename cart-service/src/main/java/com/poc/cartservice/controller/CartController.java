package com.poc.cartservice.controller;

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

import com.poc.commonlib.entity.Cart;
import com.poc.commonlib.service.CartService;

/**
 * Cart controller for all rest operations related to cart
 */
@RestController
@RequestMapping("/cart")
public class CartController {

	private static final Logger logger = LoggerFactory.getLogger(CartController.class);

	/**
	 * Cart service
	 */
	@Autowired
	private CartService cartService;

	/**
	 * Find all carts
	 * 
	 * @return
	 */
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Cart> findAllCart() {
		logger.info("Api received to fetch all carts");
		return cartService.getAllCarts();
	}

	/**
	 * Get cart for the user
	 * 
	 * @param userId
	 * @return
	 */
	@GetMapping(value = "/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Cart getCartForUser(@PathVariable("userId") int userId) {
		logger.info("Api received to fetch cart for user: " + userId);
		return cartService.getCartForTheUser(userId);
	}

	/**
	 * Create cart for the user
	 * 
	 * @param cart
	 * @return
	 */
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Cart createCart(@RequestBody Cart cart) {
		logger.info("Api call received to Create Cart");
		return cartService.create(cart);
	}

	/**
	 * Update cart by cart Id
	 * 
	 * @param cart
	 * @return
	 */
	@PutMapping(value = "/{cartId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Cart updateCart(@PathVariable("cartId") int cartId, @RequestBody Cart cart) {
		logger.info("Api call received to Update Cart by cartId: " + cartId);
		return cartService.updateById(cartId, cart);
	}

	/**
	 * Delete cart by cart id
	 * 
	 * @param cartId
	 */
	@DeleteMapping(value = "/{cartId}")
	public void deleteCart(@PathVariable("cartId") int cartId) {
		logger.info("Api call received to delete Cart by cartId: " + cartId);
		cartService.deleteById(cartId);
	}

}
