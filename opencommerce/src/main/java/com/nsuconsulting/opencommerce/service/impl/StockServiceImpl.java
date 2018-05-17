package com.nsuconsulting.opencommerce.service.impl;

import com.nsuconsulting.opencommerce.dao.StockDao;
import com.nsuconsulting.opencommerce.model.Stock;
import com.nsuconsulting.opencommerce.service.StockService;
import com.nsuconsulting.opencommerce.vo.VerifyStockVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	private StockDao stockDao;

	@Override
	public List<Stock> verifyStock(List<VerifyStockVO> verifyStockElements) {
		return new ArrayList<>();
	}

	@Override
	public List<Stock> updateStocks(List<VerifyStockVO> stocks) {
		return new ArrayList<>();
	}
}
