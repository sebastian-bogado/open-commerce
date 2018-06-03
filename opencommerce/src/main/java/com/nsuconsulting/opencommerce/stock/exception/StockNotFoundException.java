package com.nsuconsulting.opencommerce.stock.exception;

import com.nsuconsulting.opencommerce.commons.exception.NotFoundException;

public class StockNotFoundException extends NotFoundException {
	public StockNotFoundException() {
		super("", "", null, "", null);
	}
}
