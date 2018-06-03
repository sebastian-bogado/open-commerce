package com.nsuconsulting.opencommerce.product.rest.controller;

import com.nsuconsulting.opencommerce.product.exception.ProductNotFoundException;
import com.nsuconsulting.opencommerce.product.model.Product;
import com.nsuconsulting.opencommerce.product.rest.dto.CreateProductResponse;
import com.nsuconsulting.opencommerce.product.rest.dto.ProductDTO;
import com.nsuconsulting.opencommerce.product.rest.dto.ProductListDTO;
import com.nsuconsulting.opencommerce.product.service.ProductService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductRestService {
	@Autowired
	private ProductService productService;
	@Autowired
	private MapperFacade orikaMapper;

	@GetMapping
	public List<ProductListDTO> getProductList() {
		return orikaMapper.mapAsList(productService.findActiveProducts(), ProductListDTO.class);
	}

	@GetMapping("/{id}")
	public ProductDTO getProduct(@PathVariable("id") @NotNull Long id) {
		return orikaMapper.map(productService.findProductById(id).orElseThrow(() -> new ProductNotFoundException("No consegui nada")), ProductDTO.class);
	}

	@PostMapping
	public CreateProductResponse createProduct(@RequestParam("files")MultipartFile[] files,
	                                           @NotNull @NotEmpty @RequestParam("name") String name,
	                                           @RequestParam("description") String description,
	                                           @NotNull @NotEmpty @RequestParam("code") String code,
	                                           @NotNull @NotEmpty @RequestParam("price") BigDecimal price) {
		Product product = new Product();
		product.setPrice(price);
		product.setName(name);
		product.setCode(code);
		product.setDescription(description);
		return orikaMapper.map(productService.createProduct(product, files), CreateProductResponse.class);
	}

	@PatchMapping("/{productId}/{pictureId}")
	public ProductDTO updateImageToProduct(@PathVariable("productId") @NotNull Long productId, @PathVariable("pictureId") Long pictureId) {
		return orikaMapper.map(productService.setDefaultImageToProduct(productId, pictureId), ProductDTO.class);
	}

}
