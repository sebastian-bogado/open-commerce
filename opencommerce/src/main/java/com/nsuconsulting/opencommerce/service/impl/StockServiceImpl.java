package com.nsuconsulting.opencommerce.service.impl;

import com.nsuconsulting.opencommerce.dao.StockDao;
import com.nsuconsulting.opencommerce.model.Stock;
import com.nsuconsulting.opencommerce.service.StockService;
import com.nsuconsulting.opencommerce.vo.VerifyStockVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	private StockDao stockDao;
	private static final Logger LOG = LoggerFactory.getLogger(StockServiceImpl.class);

	@Override
	public List<Stock> verifyStock(List<VerifyStockVO> verifyStockElements, Long locationId) {
		List<Stock> persistedStocks = stockDao.findStocksByLocation_IdAndProduct_IdIs(locationId, verifyStockElements.stream()
				.map(VerifyStockVO::getProductId).collect(Collectors.toList()));
		List<Stock> failedStock = new ArrayList<>();
		persistedStocks.forEach(stock -> {
			double total = stock.getQuantity() -
					verifyStockElements.stream().filter(element -> stock.getProduct().getId()
							.equals(stock.getProduct().getId())).findFirst().get().getQuantity();
			if(total<0){
				failedStock.add(stock);
			}
		});
		return failedStock;
	}

	@Override
	public List<Stock> updateStocks(List<VerifyStockVO> stocks, Long locationId) {
		List<Stock> persistedStocks = stockDao.findStocksByLocation_IdAndProduct_IdIs(locationId, stocks.stream()
				.map(VerifyStockVO::getProductId).collect(Collectors.toList()));
		persistedStocks.forEach(stock -> stock.setQuantity(stock.getQuantity() -
				stocks.stream().filter(element -> stock.getProduct().getId()
						.equals(stock.getProduct().getId())).findFirst().get().getQuantity()));
		return stockDao.saveAll(persistedStocks);
	}

}
