package com.nsuconsulting.opencommerce.service.impl;

import com.nsuconsulting.opencommerce.dao.PurchaseDao;
import com.nsuconsulting.opencommerce.model.Purchase;
import com.nsuconsulting.opencommerce.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseServiceImpl implements PurchaseService {
	@Autowired
	private PurchaseDao purchaseDao;


	@Override
	public List<Purchase> findAllPurchases() {
		return purchaseDao.findAll();
	}

	@Override
	public Optional<Purchase> readPurchase(Long id) {
		return purchaseDao.findById(id);
	}

	@Override
	public Purchase createPurchase(Purchase purchase) {
		return purchaseDao.save(purchase);
	}

}
