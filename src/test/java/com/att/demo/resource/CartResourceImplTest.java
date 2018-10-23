package com.att.demo.resource;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.att.demo.service.CartServiceImpl;

@RunWith(JUnit4.class)
public class CartResourceImplTest {

	private CartResourceImpl cartResourceImpl;
	
	@Before
	public void setUp() {
		cartResourceImpl = new CartResourceImpl();
		cartResourceImpl.setCartService(new CartServiceImpl());
	}
	
	@Test
	public void testGetCart() {
		Response response = cartResourceImpl.getCart(1L);
		Assert.assertNotNull(response);
	}
	
}
