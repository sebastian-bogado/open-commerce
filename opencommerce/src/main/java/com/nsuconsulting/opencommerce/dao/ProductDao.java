package com.nsuconsulting.opencommerce.dao;

import com.nsuconsulting.opencommerce.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends LogicalDeleteableBeanDao<Product> {

	List<Product> findAllByQuantityLessThanEqualAndActiveIsTrue(Double quantity);

}
