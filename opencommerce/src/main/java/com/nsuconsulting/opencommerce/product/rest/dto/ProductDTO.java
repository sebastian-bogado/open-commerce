package com.nsuconsulting.opencommerce.product.rest.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductDTO {
	private Long id;
	private String code;
	private String name;
	private String description;
	private BigDecimal price;
	private List<PictureDTO> pictureList;
}
