package com.nsuconsulting.opencommerce.product.service.impl;

import com.nsuconsulting.opencommerce.product.dao.ProductDao;
import com.nsuconsulting.opencommerce.product.exception.ImposibleToUpdateProduct;
import com.nsuconsulting.opencommerce.product.exception.ProductExistException;
import com.nsuconsulting.opencommerce.product.model.Picture;
import com.nsuconsulting.opencommerce.product.model.Product;
import com.nsuconsulting.opencommerce.product.service.ProductService;
import com.nsuconsulting.opencommerce.commons.service.AbstractLogicalDeleteableBeanService;
import com.nsuconsulting.opencommerce.stock.exception.ImposibleToUpdateStock;
import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl extends AbstractLogicalDeleteableBeanService<Product> implements ProductService {

	private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	private ProductDao productDao;
	@Value("${image.base.folder:/home/seebogado/Pictures/opencommerce-images/}")
	private String baseFolder;
	@Value("${image.base.server.image.path:/images/}")
	private String baseImagePath;
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
		if (optProduct.isPresent()) {
			Hibernate.initialize(optProduct.get().getPictureList());
		}
		return optProduct;
	}

	@Override
	public Product createProduct(Product product, MultipartFile[] multipartFiles) {
		if (productDao.findProductByCode(product.getCode()).isPresent()) {
			throw new ProductExistException(product.getCode());
		}
		product.setPictureList(new ArrayList<>());
		for (MultipartFile file : multipartFiles) {
			String fileName = UUID.randomUUID().toString();
			File fileToSave = new File(baseFolder+fileName);
			try {
				file.transferTo(fileToSave);
				product.getPictureList().add(new Picture(baseImagePath+fileName));
			} catch (IOException e) {
				LOG.error("Error al intentar guardar las imagenes");
			}
		}
		return productDao.save(prepareToCreate(product));
	}

	@Override
	public Product setDefaultImageToProduct(Long productId, Long pictureId) {
		Product product = this.findProductById(productId).orElseThrow(()-> new ImposibleToUpdateProduct(productId.toString()));
		Picture picture = new Picture();
		picture.setId(pictureId);
		product.setDefaultPicture(picture);
		return productDao.save(prepareToUpdate(product));
	}


}
