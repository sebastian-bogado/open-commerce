package com.nsuconsulting.opencommerce.purchase.service.impl;

import com.nsuconsulting.opencommerce.purchase.dao.PurchaseDao;
import com.nsuconsulting.opencommerce.purchase.model.Purchase;
import com.nsuconsulting.opencommerce.purchase.service.PurchaseService;
import com.nsuconsulting.opencommerce.utils.service.AbstractBaseBeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImplDB extends AbstractBaseBeanService<Purchase> implements PurchaseService {
	@Autowired
	private PurchaseDao purchaseDao;




}
