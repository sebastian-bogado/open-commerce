package com.nsuconsulting.opencommerce.purchase.service.impl;

import com.nsuconsulting.opencommerce.purchase.dao.PurchaseDao;
import com.nsuconsulting.opencommerce.purchase.dao.PurchaseFilter;
import com.nsuconsulting.opencommerce.purchase.model.Purchase;
import com.nsuconsulting.opencommerce.purchase.service.PurchaseService;
import com.nsuconsulting.opencommerce.commons.service.AbstractBaseBeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImplDB extends AbstractBaseBeanService<Purchase> implements PurchaseService {
	@Autowired
	private PurchaseDao purchaseDao;


	@Override
	public List<Purchase> readAllPurchases() {
		return purchaseDao.findAll();
	}

	@Override
	public Page<Purchase> readPurchases(Integer size, Integer page) {
		Pageable pageable = new QPageRequest(page, size);
		return purchaseDao.findAll(pageable);
	}

	@Override
	public Page<Purchase> readPurchasesBybanchOffice(Integer size, Integer page, Long branchOfficeId) {
		Pageable pageable = new QPageRequest(page, size);
		return purchaseDao.findPurchasesByBranchOfficeId(pageable, branchOfficeId);
	}

	@Override
	public Page<Purchase> readPurchasesByFilter(PurchaseFilter purchaseFilter) {
		return null;
	}

	@Override
	public Purchase createPurchase(Purchase purchase) {
		return null;
	}
}
