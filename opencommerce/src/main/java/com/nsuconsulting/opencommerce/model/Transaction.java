package com.nsuconsulting.opencommerce.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@MappedSuperclass
public abstract class Transaction extends BaseBean {

	@NotNull
	private BigDecimal totalAmmount;
	private String taxId;
	private String name;
	@Enumerated(EnumType.STRING)
	private PaymentMethodEnum paymentMethod;
	@ManyToOne
	@Cascade(CascadeType.DETACH)
	private Location location;
	@ManyToOne
	private Currency currency;

}