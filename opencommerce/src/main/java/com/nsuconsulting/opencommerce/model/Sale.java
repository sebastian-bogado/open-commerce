package com.nsuconsulting.opencommerce.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Sale extends Transaction {
	@OneToMany(fetch = FetchType.LAZY)
	private List<SaleLine> saleLine;
}
