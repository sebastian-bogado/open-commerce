package com.nsuconsulting.opencommerce.model;

import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@MappedSuperclass
public class TransactionLine extends BaseBean {

	@ManyToOne
	@Cascade(CascadeType.DETACH)
	private Product product;
	@NotNull
	private Double quantity;
	@NotNull
	private BigDecimal unitPrice;
	@NotNull
	private BigDecimal subTotalPrice;

}
