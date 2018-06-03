package com.nsuconsulting.opencommerce.stock.exception;

import com.nsuconsulting.opencommerce.commons.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class ImposibleToUpdateStock extends BusinessException {
	public ImposibleToUpdateStock(Double quantity, Double quantityToBeUpdated) {
		super("","",null,"", new String[]{quantity.toString(), quantityToBeUpdated.toString()}, HttpStatus.CONFLICT);
	}
}
