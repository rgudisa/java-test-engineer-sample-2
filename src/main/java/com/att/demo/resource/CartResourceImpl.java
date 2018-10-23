package com.att.demo.resource;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.att.demo.exception.CustomError;
import com.att.demo.exception.DemoBusinessRuntimeException;
import com.att.demo.model.Cart;
import com.att.demo.service.CartService;

/**
 * This is the Controller class for Account mService
 * 
 * 
 */
@Controller
@Path("/cart")
@Produces({ MediaType.APPLICATION_JSON })
public class CartResourceImpl implements CartResource {

	public static final Logger logger = LoggerFactory
			.getLogger(CartResourceImpl.class);

	@Autowired
	private CartService cartService;

	@Override
	@GET
	@Path("/{id}")
	public Response getCart(@PathParam("id") Long id) {

		Cart cart = cartService.findCart(id);

		if (cart == null) {
			return Response.status(javax.ws.rs.core.Response.Status.NOT_FOUND)
					.build();
		}

		return Response.status(javax.ws.rs.core.Response.Status.OK)
				.entity(cart).build();
	}

	@Override
	@POST
	public Response createCart(Cart cart) {
		try {
			cartService.saveCart(cart);
		} catch (DemoBusinessRuntimeException e) {
			return Response
					.status(javax.ws.rs.core.Response.Status.BAD_REQUEST)
					.entity(new CustomError(
							e.getMessage(),
							String.valueOf(javax.ws.rs.core.Response.Status.BAD_REQUEST
									.getStatusCode()))).build();
		} catch (Exception e) {
			return Response
					.status(javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR)
					.entity(new CustomError(
							"Please contact administrator.",
							String.valueOf(javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR
									.getStatusCode()))).build();
		}
		return Response.status(javax.ws.rs.core.Response.Status.CREATED)
				.build();
	}

	@Override
	@PUT
	@Path("/{id}")
	public Response updateCart(@PathParam("id") Long id, Cart cart) {
		Cart existingCart = cartService.findCart(id);

		if (existingCart == null) {
			return Response.status(javax.ws.rs.core.Response.Status.NOT_FOUND)
					.build();
		}

		if (null == cart.getCartId()) {
			return Response
					.status(javax.ws.rs.core.Response.Status.BAD_REQUEST)
					.entity("Cart Id information not found").build();
		}

		if (cart.getCartId().longValue() != id.longValue()) {
			return Response
					.status(javax.ws.rs.core.Response.Status.BAD_REQUEST)
					.entity("Invalid content.").build();
		}

		try {
			cartService.updateCart(cart);
		} catch (DemoBusinessRuntimeException e) {
			return Response
					.status(javax.ws.rs.core.Response.Status.BAD_REQUEST)
					.entity(new CustomError(
							e.getMessage(),
							String.valueOf(javax.ws.rs.core.Response.Status.BAD_REQUEST
									.getStatusCode()))).build();
		} catch (Exception e) {
			return Response
					.status(javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR)
					.entity(new CustomError(
							"Please contact administrator.",
							String.valueOf(javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR
									.getStatusCode()))).build();
		}
		cartService.updateCart(cart);
		return Response.status(javax.ws.rs.core.Response.Status.OK)
				.entity("Cart Updated Successfully").build();
	}

	@Override
	@DELETE
	@Path("/{id}")
	public Response deleteCart(@PathParam("id") Long id) {

		Cart existingCart = cartService.findCart(id);

		if (existingCart == null) {
			return Response.status(javax.ws.rs.core.Response.Status.NOT_FOUND)
					.build();
		}

		try {
			cartService.deleteCart(id);
		} catch (DemoBusinessRuntimeException e) {
			return Response
					.status(javax.ws.rs.core.Response.Status.BAD_REQUEST)
					.entity(new CustomError(
							e.getMessage(),
							String.valueOf(javax.ws.rs.core.Response.Status.BAD_REQUEST
									.getStatusCode()))).build();
		} catch (Exception e) {
			return Response
					.status(javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR)
					.entity(new CustomError(
							"Please contact administrator.",
							String.valueOf(javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR
									.getStatusCode()))).build();
		}
		cartService.deleteCart(id);

		return Response.status(javax.ws.rs.core.Response.Status.OK).build();
	}

	public CartService getCartService() {
		return cartService;
	}

	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}
	
	

}