package com.nsuconsulting.opencommerce.branchoffice.rest.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UpdateBranchOfficeRequest {
	@NotNull
	@NotEmpty
	private String name;
	@NotNull
	@NotEmpty
	private String street;
	@NotNull
	@Min(0)
	private Long number;
	private String apartment;
}
