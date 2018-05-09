package com.nsu.duhire.webapi.authserver.exception;

public class UserExistException extends ElementExistException {

	public UserExistException(String username) {
		super(001,"", null, "", new String[]{username});
	}
}
