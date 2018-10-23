package com.att.demo.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.att.demo.exception.DemoBusinessRuntimeException;
import com.att.demo.model.Cart;

@RunWith(JUnit4.class)
public class CartServiceImplTest {

	private CartServiceImpl cartServiceImpl;
	
	@Before
	public void setUp() {
		cartServiceImpl = new CartServiceImpl();
	}
	
	@Test
	public void testFindCart(){
		Cart cart = cartServiceImpl.findCart(0);
		Assert.assertNull(cart);
	}
	
	@Test
	public void testSaveCart(){
		Cart cart = new Cart();
		cartServiceImpl.saveCart(cart);
		Cart newCart = cartServiceImpl.findCart(1);
		Assert.assertNotNull(newCart);
		Assert.assertEquals("Save did not work.", Long.valueOf(1L), newCart.getCartId());
	}
	
	@Test(expected=DemoBusinessRuntimeException.class)
	public void testSaveCartWithoutDetails(){
		cartServiceImpl.saveCart(null);
	}
}
