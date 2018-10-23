package com.att.demo.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.ws.rs.core.Response;

import org.joda.time.LocalDateTime;
import org.springframework.stereotype.Service;

import com.att.demo.exception.DemoBusinessRuntimeException;
import com.att.demo.model.Cart;



@Service("cartService")
public class CartServiceImpl implements CartService{

	private static Map<Long, Cart> cartsRepo = new ConcurrentHashMap<>();
	
	@Override
	public Cart findCart(long id) {
		return cartsRepo.get(id);
	}

	@Override
	public void saveCart(Cart cart) {
		if(cart == null) {
			throw new DemoBusinessRuntimeException("Cart details are not provided.");
		}
		if(cart.getCartId() != null) {
			throw new DemoBusinessRuntimeException("Cart id is not allowed.");
		}
		
		long cartId = cartsRepo.size() + 1;
		cart.setCartId(cartId);
		cart.setCreatedDate(LocalDateTime.now().toString());
		cartsRepo.put(cartId, cart);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCart(long id) {
		if (!cartsRepo.containsKey(id)) {
			throw new DemoBusinessRuntimeException("Cart id doesn't exists");
		}
		
		cartsRepo.remove(id);
		
	}

	@Override
	public void updateCart(Cart cart) {
		if(cart == null) {
			throw new DemoBusinessRuntimeException("Cart details are not provided.");
		}
		
		if(cart.getCartId() != null) {
			throw new DemoBusinessRuntimeException("Cart id is not allowed.");
		}
		
		if (!cartsRepo.containsKey(cart.getCartId())) {
			throw new DemoBusinessRuntimeException("Cart id doesn't exists");
		}
		
		Cart existingCart = cartsRepo.get(cart.getCartId());
		existingCart.setCompletedDate(LocalDateTime.now().toString());
		existingCart.setItems(cart.getItems());
		
	}	
	
}
