package com.nsuconsulting.opencommerce.exception;

import org.springframework.http.HttpStatus;

public abstract class EntityExistException extends BusinessException {
	public EntityExistException(String code, String message, String[] messageArguments, String description, String[] descriptionArguments) {
		super(code, message, messageArguments, description, descriptionArguments, HttpStatus.CONFLICT);
	}
}
