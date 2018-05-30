package com.nsuconsulting.opencommerce.product.service;

import com.nsuconsulting.opencommerce.product.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

	List<Product> findActiveProducts();
	List<Product> findNonActiveProducts();
	Optional<Product> findLightProductById(Long id);
	Optional<Product> findProductById(Long id);

}
