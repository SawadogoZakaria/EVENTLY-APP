package com.evently.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value =HttpStatus.NOT_FOUND )
public class ServceNotFoundException extends RuntimeException {
	public ServceNotFoundException(String message) {
		super(message);
	}

}
