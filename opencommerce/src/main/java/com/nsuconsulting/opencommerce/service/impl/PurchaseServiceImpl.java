package com.nsuconsulting.opencommerce.service.impl;

import com.nsuconsulting.opencommerce.dao.PurchaseDao;
import com.nsuconsulting.opencommerce.exception.CanCreatePurchaseException;
import com.nsuconsulting.opencommerce.model.Purchase;
import com.nsuconsulting.opencommerce.model.Stock;
import com.nsuconsulting.opencommerce.service.ProductService;
import com.nsuconsulting.opencommerce.service.PurchaseService;
import com.nsuconsulting.opencommerce.service.StockService;
import com.nsuconsulting.opencommerce.vo.VerifyStockVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PurchaseServiceImpl extends AbstractBaseBeanService<Purchase> implements PurchaseService {
	@Autowired
	private PurchaseDao purchaseDao;
	@Autowired
	private ProductService productService;
	@Autowired
	private StockService stockService;


	@Override
	public List<Purchase> findAllPurchases() {
		return purchaseDao.findAll();
	}

	@Override
	public Optional<Purchase> readPurchase(Long id) {
		return purchaseDao.findById(id);
	}

	@Override
	@Transactional
	public Purchase createPurchase(Purchase purchase) {
		List<Stock> failedProducts = stockService.verifyStock(purchase
				.getPurchaseLines().stream().map(element -> new VerifyStockVO(element.getProduct().getId(), element.getQuantity()))
				.collect(Collectors.toList()));
		if(!failedProducts.isEmpty()) {
			throw new CanCreatePurchaseException(failedProducts.stream().map(Stock::getProduct).collect(Collectors.toList()));
		}
		stockService.updateStocks(purchase.getPurchaseLines().stream().map(element -> new VerifyStockVO(element.getProduct().getId(), element.getQuantity()))
				.collect(Collectors.toList()));
		return purchaseDao.save(prepareToCreate(purchase));
	}

}
