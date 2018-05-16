package com.nsuconsulting.opencommerce.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Data
@Entity
public class PurchaseLine extends TransactionLine {

	@ManyToOne
	private Purchase purchase;

}
