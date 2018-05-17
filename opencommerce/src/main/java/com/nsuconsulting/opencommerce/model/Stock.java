package com.nsuconsulting.opencommerce.model;

import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Stock {

	@Id
	@GeneratedValue
	private Long id;
	@NotNull
	@Min(0)
	private Double quantity;
	@ManyToOne
	@Cascade(CascadeType.DETACH)
	private Product product;
	@ManyToOne
	@Cascade(CascadeType.DETACH)
	private Location location;

}
