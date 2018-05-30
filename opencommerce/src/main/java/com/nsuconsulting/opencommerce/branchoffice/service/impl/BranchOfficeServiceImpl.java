package com.nsuconsulting.opencommerce.branchoffice.service.impl;

import com.nsuconsulting.opencommerce.branchoffice.dao.BranchOfficeDao;
import com.nsuconsulting.opencommerce.branchoffice.model.BranchOffice;
import com.nsuconsulting.opencommerce.branchoffice.service.BranchOfficeService;
import com.nsuconsulting.opencommerce.utils.service.AbstractLogicalDeleteableBeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BranchOfficeServiceImpl extends AbstractLogicalDeleteableBeanService<BranchOffice> implements BranchOfficeService {

	@Autowired
	private BranchOfficeDao branchOfficeDao;

	@Override
	public List<BranchOffice> findALlBranchOffices() {
		return branchOfficeDao.findAll();
	}

	@Override
	public Optional<BranchOffice> findBranchOfficeById(Long id) {


		return branchOfficeDao.findById(id);
	}

	@Override
	public BranchOffice createBranchOffice(BranchOffice branchOffice) {

		return null;
	}

	@Override
	public BranchOffice updateBranchOffice(BranchOffice branchOffice) {
		return null;
	}

	@Override
	public void deleteBranchOffice(Long id) {

	}
}
