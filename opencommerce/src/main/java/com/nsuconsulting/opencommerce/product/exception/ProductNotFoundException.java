package com.nsuconsulting.opencommerce.product.exception;

import com.nsuconsulting.opencommerce.commons.exception.NotFoundException;

public class ProductNotFoundException extends NotFoundException {
	public ProductNotFoundException(String identifier) {
		super("","",null,"", new String[]{identifier});
	}
}
