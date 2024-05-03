package com.microservice.hotelservice.exception;

public class ResouceNotFoundException extends RuntimeException{

	public ResouceNotFoundException(String msg) {
		super(msg);
	}
}
