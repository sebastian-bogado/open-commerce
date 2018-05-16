package com.nsuconsulting.opencommerce.exception;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProductExistException extends EntityExistException {
	public ProductExistException(@NotNull @NotEmpty String code) {
		super("10001", "product.exist.exception.message",null, "product.exist.exception.description", null);
	}
}
