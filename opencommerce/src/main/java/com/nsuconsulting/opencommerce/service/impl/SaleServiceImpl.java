package com.nsuconsulting.opencommerce.service.impl;

import com.nsuconsulting.opencommerce.dao.SaleDao;
import com.nsuconsulting.opencommerce.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceImpl implements SaleService {
	@Autowired
	private SaleDao saleDao;
}
