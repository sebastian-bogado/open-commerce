package com.nsuconsulting.opencommerce.service;

import com.nsuconsulting.opencommerce.model.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseService {

	List<Purchase> findAllPurchases();
	Optional<Purchase> readPurchase(Long id);
	Purchase createPurchase(Purchase purchase);

}
