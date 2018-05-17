package com.nsuconsulting.opencommerce.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VerifyStockVO {
	private Long productId;
	private Double quantity;
}
