package com.nsuconsulting.opencommerce.purchase.service;

import com.nsuconsulting.opencommerce.purchase.dao.PurchaseFilter;
import com.nsuconsulting.opencommerce.purchase.model.Purchase;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PurchaseService {
	List<Purchase> readAllPurchases();
	Page<Purchase> readPurchases(Integer size, Integer page);
	Page<Purchase> readPurchasesBybanchOffice(Integer size, Integer page, Long branchOfficeId);
	Page<Purchase> readPurchasesByFilter(PurchaseFilter purchaseFilter);
	Purchase createPurchase(Purchase purchase);
}
