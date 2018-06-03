package com.nsuconsulting.opencommerce.stock.dao;

import com.nsuconsulting.opencommerce.stock.model.Stock;
import com.nsuconsulting.opencommerce.commons.dao.BaseBeanDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StockDao extends BaseBeanDao<Stock> {

	Optional<Stock> findStockByBranchOfficeIdAndProductId(Long branchOfficeId, Long productId);
	List<Stock> findAllByBranchOfficeId(Long branchOfficeId);
	List<Stock> findAllByProductId(Long productId);

}
