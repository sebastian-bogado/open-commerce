package com.nsu.duhire.webapi.authserver.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomError {

	private Integer code;
	private String message;
	private String description;
	private Integer status;

}
