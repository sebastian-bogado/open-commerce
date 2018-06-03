package com.nsuconsulting.opencommerce.commons.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomError {

	private String code;
	private String message;
	private String description;
	private Integer status;

}
