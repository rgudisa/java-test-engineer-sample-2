package com.att.demo.resource;

import io.swagger.annotations.Api;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.att.demo.model.Cart;


/**
 * This is the Interface definition for Account mService
 * 
 * 
 */
@Api("cart")
@Path("/cart")
@Produces({MediaType.APPLICATION_JSON})
public interface CartResource {	
    
	@GET
	@Path("/{id}")
	public Response getCart(@PathParam("id") Long id);
	
	@POST
	public Response createCart(Cart cart);
	
	@PUT
	@Path("/{id}")
	public Response updateCart(@PathParam("id") Long id, Cart cart);
	
	@DELETE
	@Path("/{id}")
	public Response deleteCart(@PathParam("id") Long id);
	
}