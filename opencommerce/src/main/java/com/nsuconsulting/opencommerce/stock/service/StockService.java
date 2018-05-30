package com.nsuconsulting.opencommerce.stock.service;

import com.nsuconsulting.opencommerce.stock.model.Stock;

import java.util.List;
import java.util.Optional;

public interface StockService {

	List<Stock> readStocksByProductId(Long productId);
	List<Stock> readStocksByBranchOfficeId(Long branchOfficeId);
	Optional<Stock> readStockByBranchOfficeIdAndProductId(Long branchOfficeId, Long productId);
	Stock createStock(Long branchOfficeId, Long productId);
	Stock updateStock(Long branchOfficeId, Long productId, Double quantity);

}
