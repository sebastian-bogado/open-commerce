package com.nsuconsulting.opencommerce.branchoffice.service;

import com.nsuconsulting.opencommerce.branchoffice.model.BranchOffice;

import java.util.List;
import java.util.Optional;

public interface BranchOfficeService {

	List<BranchOffice> findALlBranchOffices();
	Optional<BranchOffice> findBranchOfficeById(Long id);
	BranchOffice createBranchOffice(BranchOffice branchOffice);
	BranchOffice updateBranchOffice(BranchOffice branchOffice);
	void deleteBranchOffice(Long id);


}
