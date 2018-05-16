package com.nsuconsulting.opencommerce.rest.controller;

import com.nsuconsulting.opencommerce.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sales")
public class SaleRestController {
	@Autowired
	private SaleService saleService;



}
