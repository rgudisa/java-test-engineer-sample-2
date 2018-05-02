package com.att.demo.resource;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.swagger.annotations.Api;


/**
 * This is the Interface definition for Account mService
 * 
 * 
 */
@Api("cart")
@Path("/cart")
@Produces({MediaType.APPLICATION_JSON})
public interface CartResource {	
    

	
}