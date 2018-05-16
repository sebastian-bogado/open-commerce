package com.nsuconsulting.opencommerce.service.impl;

import com.nsuconsulting.opencommerce.dao.ProductDao;
import com.nsuconsulting.opencommerce.exception.ProductExistException;
import com.nsuconsulting.opencommerce.exception.ProductNotFoundException;
import com.nsuconsulting.opencommerce.model.Product;
import com.nsuconsulting.opencommerce.service.ProductService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service //Esto va a ser un servicio que va a ser consumido.
public class ProductServiceImpl extends AbstractLogicalDeleteableService<Product> implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> findActiveProducts() {
		return productDao.findAllByActiveIsTrue();
	}

	@Override
	public List<Product> findNonActiveProducts() {
		return productDao.findAllByActiveIsFalse();
	}

	@Override
	public Optional<Product> findLightProductById(Long id) {
		return productDao.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Product> findProductById(Long id) {
		Optional<Product> optProduct = this.findLightProductById(id);
		if(optProduct.isPresent()) {
			Hibernate.initialize(optProduct.get().getPictureList());
		}
		return optProduct;
	}

	@Override
	public Product createProduct(Product product) {
		if(productDao.findProductByCode(product.getCode()).isPresent()) {
			throw new ProductExistException(product.getCode());
		}
		return productDao.save(prepareToCreate(product));
	}

	@Override
	public Product updateProduct(Product product) {
		Product persistedProduct = this.findProductById(product.getId()).orElseThrow(()-> new ProductNotFoundException(product.getId()));
		if(!persistedProduct.getCode().equals(product.getCode()) && productDao.findProductByCode(product.getCode()).isPresent()) {
			throw new ProductExistException(product.getCode());
		}
		persistedProduct.setCode(product.getCode());
		persistedProduct.setDescription(product.getDescription());
		persistedProduct.setName(product.getName());
		persistedProduct.setPrice(product.getPrice());
		persistedProduct.setQuantity(persistedProduct.getQuantity());
		return productDao.save(prepareToUpdate(product));
	}

	@Override
	public Product prepareToCreate(Product product) {
		//TODO view images
		return super.prepareToCreate(product);
	}

	@Override
	public Product prepareToUpdate(Product product) {
		//TODO view images
		return super.prepareToUpdate(product);
	}

	@Override
	public void deleteProduct(Long id) {
		productDao.deleteById(id);
	}

	@Override
	public void deleteProduct(String uuid) {
		productDao.deleteByUuid(uuid);
	}


}
