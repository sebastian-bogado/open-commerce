package com.nsuconsulting.opencommerce.product.model;

import com.nsuconsulting.opencommerce.commons.model.LogicalDeleteableBean;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
public class Product extends LogicalDeleteableBean {

	@NotNull
	@NotEmpty
	private String code;
	@NotNull
	@NotEmpty
	private String name;
	private String description;
	@NotNull
	@Min(0)
	private BigDecimal price;
	@OneToOne(cascade = CascadeType.DETACH)
	private Picture defaultPicture;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Picture> pictureList;

}
