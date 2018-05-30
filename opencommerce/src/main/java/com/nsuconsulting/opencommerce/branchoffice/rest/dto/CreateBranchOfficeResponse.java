package com.nsuconsulting.opencommerce.branchoffice.rest.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CreateBranchOfficeResponse {
	private Long id;
	private String name;
	private String street;
	private Long number;
	private String apartment;
}
