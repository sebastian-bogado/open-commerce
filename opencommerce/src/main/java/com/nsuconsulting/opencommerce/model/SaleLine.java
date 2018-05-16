package com.nsuconsulting.opencommerce.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Data
@Entity
public class SaleLine extends TransactionLine {

	@ManyToOne
	private Sale sale;

}
