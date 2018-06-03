package com.nsuconsulting.opencommerce.branchoffice.dao;

import com.nsuconsulting.opencommerce.branchoffice.model.BranchOffice;
import com.nsuconsulting.opencommerce.commons.dao.LogicalDeleteableBeanDao;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BranchOfficeDao extends LogicalDeleteableBeanDao<BranchOffice> {

	Optional<BranchOffice> findByNormalizedName(String normalizedName);

}
