package com.nsuconsulting.opencommerce.purchase.dao;

import com.nsuconsulting.opencommerce.purchase.model.Purchase;
import com.nsuconsulting.opencommerce.commons.dao.BaseBeanDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseDao extends BaseBeanDao<Purchase> {
	Page<Purchase> findPurchasesByBranchOfficeId(Pageable pageable, Long branchOfficeId);
}
