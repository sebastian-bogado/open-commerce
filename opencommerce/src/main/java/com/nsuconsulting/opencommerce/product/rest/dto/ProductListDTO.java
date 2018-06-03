package com.nsuconsulting.opencommerce.product.rest.dto;

import lombok.Data;

@Data
public class ProductListDTO {
	private Long id;
	private String code;
	private String name;
	private PictureDTO defaultPicture;
}
