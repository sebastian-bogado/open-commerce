package com.nsu.duhire.webapi.authserver.rest.controller.dto;

import lombok.Data;

@Data
public class UpdateAdminUserRequest extends CreateAdminUserRequest {
	private Long id;
}
