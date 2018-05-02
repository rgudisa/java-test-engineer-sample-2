package com.att.demo.service;

import com.att.demo.model.Cart;

public interface CartService {

	Cart findCart(long id);

	void saveCart(Cart cart);

	void deleteCart(long id);

	void updateCart(Cart cart);

}
