package com.nsuconsulting.opencommerce.branchoffice.rest.dto;

import lombok.Data;

@Data
public class BranchOfficeDTO extends BranchOfficeListDTO {

	private Long id;
	private String name;
	private String street;
	private Long number;
	private String apartment;

}
