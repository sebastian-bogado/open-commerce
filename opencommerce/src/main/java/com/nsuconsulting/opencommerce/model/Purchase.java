package com.nsuconsulting.opencommerce.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Purchase extends Transaction {
	@OneToMany
	private List<PurchaseLine> purchaseLines;
}
