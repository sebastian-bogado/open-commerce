package com.nsuconsulting.opencommerce.product.dao;

import com.nsuconsulting.opencommerce.product.model.Product;
import com.nsuconsulting.opencommerce.utils.dao.LogicalDeleteableBeanDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductDao extends LogicalDeleteableBeanDao<Product> {

	List<Product> findProductsByIdInAndActiveIsTrue(List<Long> ids);
	Optional<Product> findProductByCode(String code);

}
