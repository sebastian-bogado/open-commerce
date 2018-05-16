package com.nsuconsulting.opencommerce.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Currency {

	@Id
	@GeneratedValue
	private Long id;
	@NotNull
	private String name;

}
