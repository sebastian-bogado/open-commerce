package com.nsuconsulting.opencommerce.rest.controller;

import com.nsuconsulting.opencommerce.model.Product;
import com.nsuconsulting.opencommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductRestService {
	@Autowired
	private ProductService productService;

	@GetMapping
	public List<Product> getProductList() {
		return productService.findActiveProducts();
	}

	@GetMapping("/{id}")
	public Product getProduct(@PathVariable("id") @NotNull Long id) {
		return productService.findProductById(id).orElseThrow(() -> new RuntimeException("No consegui nada"));
	}


}
