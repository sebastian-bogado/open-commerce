package com.nsuconsulting.opencommerce.model;

import lombok.Data;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@MappedSuperclass
public class TransactionLine extends BaseBean {

	@ManyToOne
	private Product product;
	@NotNull
	private Integer quantity;
	@NotNull
	private BigDecimal unitPrice;
	@NotNull
	private BigDecimal subTotalPrice;

}
