package com.temperies.Movies.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

	private Logger logger = LoggerFactory.getLogger(ControllerAdvisor.class);

	@ExceptionHandler(GenericException.class)
	public ResponseEntity<ErrorResponseDTO> handle(GenericException ex) {
		logger.error(ex.getMessage(), ex);
		ErrorResponseDTO errorDTO = new ErrorResponseDTO(ex.getStatus(), ex.getMessage());
		return new ResponseEntity<>(errorDTO, ex.getStatus());
	}
	
}
