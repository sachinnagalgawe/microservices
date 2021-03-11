package com.poc.commonlib.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.poc.commonlib.entity.Cart;
import com.poc.commonlib.repository.CartRepository;
import com.poc.commonlib.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;

	@Override
	public Cart getCartForTheUser(Integer userId) {
		Cart cart = cartRepository.findOneByUserId(userId);
		if (cart != null) {
			return cart;
		}
		return null;
	}

	@Override
	public Cart create(Cart cart) {
		return cartRepository.save(cart);
	}

	@Override
	public List<Cart> getAllCarts() {
		return (List<Cart>) cartRepository.findAll();
	}

	@Override
	public Cart updateById(Integer cartId, Cart cart) {
		Cart existingCart = cartRepository.findOneById(cartId);
		if (existingCart != null) {
			if (cart.getUser() != null) {
				existingCart.setUser(cart.getUser());
			}
			if (!CollectionUtils.isEmpty(cart.getProducts())) {
				existingCart.setProducts(cart.getProducts());
			}
		}
		return cartRepository.save(existingCart);
	}

	@Override
	public void deleteById(Integer cartId) {
		cartRepository.deleteById(cartId);
	}

}
