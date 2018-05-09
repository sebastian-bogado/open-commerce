package com.nsu.duhire.webapi.authserver.exception;

public class RoleExistException extends ElementExistException {

	public RoleExistException(String roleName) {
		super(001,"", null, "", new String[]{roleName});
	}
}
