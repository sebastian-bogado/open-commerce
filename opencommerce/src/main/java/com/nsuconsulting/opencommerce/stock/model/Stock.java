package com.nsuconsulting.opencommerce.stock.model;

import com.nsuconsulting.opencommerce.stock.exception.ImposibleToUpdateStock;
import com.nsuconsulting.opencommerce.utils.model.BaseBean;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Stock extends BaseBean {

	private Long branchOfficeId;
	private Long productId;
	private Double quantity;

	public void updateQuantity(Double quantityToBeModified) {
		if( quantityToBeModified.doubleValue() < 0 &&this.quantity.compareTo(Math.abs(quantityToBeModified)) < 0) {
			throw new ImposibleToUpdateStock(quantity, quantityToBeModified);
		}
		this.quantity+=quantityToBeModified;
	}


}
