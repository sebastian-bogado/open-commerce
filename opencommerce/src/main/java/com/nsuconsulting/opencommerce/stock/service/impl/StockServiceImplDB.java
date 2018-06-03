package com.nsuconsulting.opencommerce.stock.service.impl;

import com.nsuconsulting.opencommerce.stock.dao.StockDao;
import com.nsuconsulting.opencommerce.stock.exception.StockNotFoundException;
import com.nsuconsulting.opencommerce.stock.model.Stock;
import com.nsuconsulting.opencommerce.stock.service.StockService;
import com.nsuconsulting.opencommerce.commons.service.AbstractBaseBeanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockServiceImplDB extends AbstractBaseBeanService<Stock> implements StockService {

	@Autowired
	private StockDao stockDao;

	private static final Logger LOG = LoggerFactory.getLogger(StockServiceImplDB.class);

	@Override
	public List<Stock> readStocksByProductId(Long productId) {
		return stockDao.findAllByProductId(productId);
	}

	@Override
	public List<Stock> readStocksByBranchOfficeId(Long branchOfficeId) {
		return stockDao.findAllByBranchOfficeId(branchOfficeId);
	}

	@Override
	public Optional<Stock> readStockByBranchOfficeIdAndProductId(Long branchOfficeId, Long productId) {
		return stockDao.findStockByBranchOfficeIdAndProductId(branchOfficeId, productId);
	}

	@Override
	public Stock createStock(Long branchOfficeId, Long productId) {
		Stock stock = new Stock();
		stock.setBranchOfficeId(branchOfficeId);
		stock.setProductId(productId);
		stock.setQuantity(0D);
		return stockDao.save(prepareToCreate(stock));
	}

	@Override
	public Stock updateStock(Long branchOfficeId, Long productId, Double quantity) {
		Stock persistedStock = this.readStockByBranchOfficeIdAndProductId(branchOfficeId, productId).orElseThrow(() -> {
			LOG.error("El stock al que estas queriendo acceder no se encuentra disponible");
			return new StockNotFoundException();
		});
		persistedStock.updateQuantity(quantity);
		return prepareToCreate(persistedStock);
	}
}
