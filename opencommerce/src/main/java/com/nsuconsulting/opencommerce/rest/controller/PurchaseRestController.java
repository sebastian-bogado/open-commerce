package com.nsuconsulting.opencommerce.rest.controller;

import com.nsuconsulting.opencommerce.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/purchases")
public class PurchaseRestController {
	@Autowired
	private PurchaseService purchaseService;

}
