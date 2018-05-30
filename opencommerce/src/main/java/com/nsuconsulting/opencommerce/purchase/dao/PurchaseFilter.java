package com.nsuconsulting.opencommerce.purchase.dao;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PurchaseFilter {
	private LocalDateTime creationDateLowerThan;
	private LocalDateTime creationDateGreaterThan;
	private Long branchOfficeId;
	private Double totalLowerThan;
	private Double totalGreaterThan;
	private Long productId;
}
