package com.nsuconsulting.opencommerce.product.exception;

import com.nsuconsulting.opencommerce.commons.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class ImposibleToUpdateProduct extends BusinessException {
	public ImposibleToUpdateProduct(String identifier) {
		super("","",null,"", new String[]{identifier}, HttpStatus.CONFLICT);
	}
}
