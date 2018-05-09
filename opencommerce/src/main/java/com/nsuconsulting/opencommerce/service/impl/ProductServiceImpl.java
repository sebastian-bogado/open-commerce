package com.nsuconsulting.opencommerce.service.impl;

import com.nsuconsulting.opencommerce.dao.ProductDao;
import com.nsuconsulting.opencommerce.model.Product;
import com.nsuconsulting.opencommerce.service.ProductService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service //Esto va a ser un servicio que va a ser consumido.
public class ProductServiceImpl implements ProductService {

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
}
