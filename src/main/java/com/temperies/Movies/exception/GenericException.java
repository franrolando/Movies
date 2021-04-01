package com.temperies.Movies.exception;

import org.springframework.http.HttpStatus;

public class GenericException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private HttpStatus status;
	private String message;

	public GenericException(HttpStatus status, String message) {
		super();
		this.message = message;
		this.status = status;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}