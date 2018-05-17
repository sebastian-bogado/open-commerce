package com.nsuconsulting.opencommerce.exception;

import com.nsuconsulting.opencommerce.model.Product;
import org.springframework.http.HttpStatus;

import java.util.List;

public class CanCreatePurchaseException extends BusinessException {
	public CanCreatePurchaseException(List<Product> products) {
		super("","",null,"", new String[]{buildString(products)},HttpStatus.CONFLICT);

	}

	private static String buildString(List<Product> products) {
		StringBuilder stringBuilder= new StringBuilder();
		products.forEach(element -> stringBuilder.append(element.getName()));
		return stringBuilder.toString();
	}

}
