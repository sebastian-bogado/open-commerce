package com.nsuconsulting.opencommerce.dao;

import com.nsuconsulting.opencommerce.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductDao extends LogicalDeleteableBeanDao<Product> {

	List<Product> findAllByQuantityLessThanEqualAndActiveIsTrue(Double quantity);
	Optional<Product> findProductByCode(String code);

}
