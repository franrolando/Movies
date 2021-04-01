package com.temperies.Movies.exception;

import org.springframework.http.HttpStatus;

public class ErrorResponseDTO {

	private int code;
	private String message;
	private String status;

	public ErrorResponseDTO(HttpStatus code, String message) {
		this.code = code.value();
		this.status = code.getReasonPhrase();
		this.message = message;
	}

	public int getCode() {
		return this.code;
	}

	public String getMessage() {
		return this.message;
	}

	public String getStatus() {
		return this.status;
	}

}
