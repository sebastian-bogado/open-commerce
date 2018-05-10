package com.nsuconsulting.opencommerce.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Picture extends BaseBean {
	@NotNull
	@NotEmpty
	private String path;
	@ManyToOne(fetch = FetchType.LAZY) //Muchas instancias de esta clase, van a estar ligadas con solo una instancia del atributo.
	private Product product;
}
