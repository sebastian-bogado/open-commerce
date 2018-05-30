package com.nsuconsulting.opencommerce.purchase.dao;

import com.nsuconsulting.opencommerce.purchase.model.Purchase;

import java.util.List;

public interface CustomPurchaseDao {
	List<Purchase> readPurchaseByFilter(PurchaseFilter purchaseFilter);
}
