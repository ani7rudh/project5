package com.electro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.electro.daoimpl.CartItemDAOImpl;
import com.electro.model.CartItem;

@Service
@Transactional

public class CartItemService {
	@Autowired
	CartItemDAOImpl cartItemDAOImpl;
	
	public void addCartItem(CartItem cartItem) {
       cartItemDAOImpl.addCartItem(cartItem);
	}
	
	public CartItem getCartListById(int cartItemId) {
     return cartItemDAOImpl.getCartListById(cartItemId);
	}
	
}


