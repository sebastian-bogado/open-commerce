package com.nsuconsulting.opencommerce.service;

import com.nsuconsulting.opencommerce.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

	List<Product> findActiveProducts();
	List<Product> findNonActiveProducts();
	Optional<Product> findLightProductById(Long id);
	Optional<Product> findProductById(Long id);
	Product createProduct(Product product);
	Product updateProduct(Product product);
	void deleteProduct(Long id);
	void deleteProduct(String product);

}