package com.nsuconsulting.opencommerce.exception;

public class ProductNotFoundException extends NotFoundException {
	public ProductNotFoundException(Long id) {
		super("", "", null, "", new String[]{id.toString()});
	}

	public ProductNotFoundException(String code) {
		super("", "", null, "", new String[]{code});
	}

}
