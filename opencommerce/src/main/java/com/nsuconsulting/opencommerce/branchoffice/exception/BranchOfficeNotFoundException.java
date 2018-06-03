package com.nsuconsulting.opencommerce.branchoffice.exception;

import com.nsuconsulting.opencommerce.commons.exception.NotFoundException;

public class BranchOfficeNotFoundException extends NotFoundException {
	public BranchOfficeNotFoundException(String identifier) {
		super("","",null,"", new String[]{identifier});
	}
}
