package com.nsuconsulting.opencommerce.product.service;

import com.nsuconsulting.opencommerce.product.model.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface ProductService {

	List<Product> findActiveProducts();
	List<Product> findNonActiveProducts();
	Optional<Product> findLightProductById(Long id);
	Optional<Product> findProductById(Long id);
	Product createProduct(Product product, MultipartFile[] multipartFiles);
	Product setDefaultImageToProduct(Long productId, Long pictureId);
}
