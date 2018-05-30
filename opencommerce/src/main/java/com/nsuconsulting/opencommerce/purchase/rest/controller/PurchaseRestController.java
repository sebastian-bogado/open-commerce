package com.nsuconsulting.opencommerce.purchase.rest.controller;

import com.nsuconsulting.opencommerce.purchase.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/purchase")
public class PurchaseRestController {
	@Autowired
	private PurchaseService purchaseService;



}
