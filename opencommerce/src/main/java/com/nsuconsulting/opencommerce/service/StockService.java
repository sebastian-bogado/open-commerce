package com.nsuconsulting.opencommerce.service;

import com.nsuconsulting.opencommerce.model.Stock;
import com.nsuconsulting.opencommerce.vo.VerifyStockVO;

import java.util.List;

public interface StockService {

	List<Stock> verifyStock(List<VerifyStockVO> verifyStockElements, Long locationId);
	List<Stock> updateStocks(List<VerifyStockVO> stocks, Long locationId);

}
