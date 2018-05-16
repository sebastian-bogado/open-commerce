package com.nsuconsulting.opencommerce.rest.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class CreateProductRequest {

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
	@NotNull
	@Min(0)
	private Double quantity;

}
