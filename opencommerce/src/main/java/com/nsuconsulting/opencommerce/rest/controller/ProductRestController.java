package com.nsuconsulting.opencommerce.rest.controller;

import com.nsuconsulting.opencommerce.mapper.ProductMapper;
import com.nsuconsulting.opencommerce.model.Product;
import com.nsuconsulting.opencommerce.rest.dto.CreateProductRequest;
import com.nsuconsulting.opencommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductMapper productMapper;

	@GetMapping
	public List<Product> getProductList() {
		return productService.findActiveProducts();
	}

	@GetMapping("/{id}")
	public Product getProduct(@PathVariable("id") @NotNull Long id) {
		return productService.findProductById(id).orElseThrow(() -> new RuntimeException("No consegui nada"));
	}

	@PostMapping
	public Product createProduct(@RequestBody @Valid @NotNull CreateProductRequest productDTO) {
		return productService.createProduct(productMapper.map(productDTO, Product.class));
	}

	@PutMapping
	public Product updateProduct(@RequestBody @Valid @NotNull CreateProductRequest productDTO) {
		return productService.updateProduct(productMapper.map(productDTO, Product.class));
	}

	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable("id") @NotNull Long id) {
		productService.deleteProduct(id);
	}

}
