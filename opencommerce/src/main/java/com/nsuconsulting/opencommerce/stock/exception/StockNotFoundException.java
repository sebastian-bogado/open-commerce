package com.nsuconsulting.opencommerce.stock.exception;

import com.nsuconsulting.opencommerce.utils.exception.NotFoundException;

public class StockNotFoundException extends NotFoundException {
	public StockNotFoundException() {
		super("", "", null, "", null);
	}
}
