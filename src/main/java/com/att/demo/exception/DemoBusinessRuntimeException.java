package com.att.demo.exception;

public class DemoBusinessRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DemoBusinessRuntimeException(){
		super();
	}
	
	public DemoBusinessRuntimeException(String message) {
		super(message);
	}
	
	public DemoBusinessRuntimeException(Throwable cause){
		super(cause);
	}
	
	public DemoBusinessRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}
	
	

}
