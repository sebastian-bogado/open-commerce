package com.nsuconsulting.opencommerce.product.exception;

import com.nsuconsulting.opencommerce.commons.exception.ElementExistException;

public class ProductExistException extends ElementExistException {
	public ProductExistException(String code) {
		super("","",null,"", new String[]{code});
	}
}
