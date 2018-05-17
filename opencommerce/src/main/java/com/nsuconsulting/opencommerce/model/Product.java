package com.nsuconsulting.opencommerce.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Entity //Esto indica que va a ser una tabla en la base de datos.
@Data //Esto indica que tiene que generar getters, setters, toString, equals y hashcode
public class Product extends LogicalDeleteableBean {

	/*@Id //Significa que el atributo que esta anotado, va a ser un id
	@GeneratedValue //Significa que el atributo que esta anotado va a ser un valor autogenerado
	private Long id;*/
	@NotNull //El campo este no puede ser nulo
	@NotEmpty // El campo este no puede estar vacio
	private String code;
	@NotNull
	@NotEmpty
	private String name;
	private String description;
	@NotNull
	@Min(0)
	private BigDecimal price;
	@OneToMany(fetch = FetchType.LAZY)
	private List<Picture> pictureList;

}
