package com.example.demo.exceptions;

public class CustomExceptions extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public CustomExceptions(String message, Throwable cause) {
		super(message, cause);
		
	}

	public CustomExceptions(String message) {
		super(message);
		
	}

}
