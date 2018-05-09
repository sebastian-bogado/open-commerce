package com.nsu.duhire.webapi.authserver.rest.controller.dto;

import lombok.Data;

@Data
public class UserListDTO {

	private String id;
	private String email;
	private String name;
	private String lastName;

}
