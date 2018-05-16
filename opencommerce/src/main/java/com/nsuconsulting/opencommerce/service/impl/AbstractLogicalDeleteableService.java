package com.nsuconsulting.opencommerce.service.impl;

import com.nsuconsulting.opencommerce.model.LogicalDeleteableBean;

public class AbstractLogicalDeleteableService<T extends LogicalDeleteableBean> extends AbstractBaseBeanService<T> {
	@Override
	protected T prepareToCreate(T entity) {
		entity.setActive(true);
		return entity;
	}
}
