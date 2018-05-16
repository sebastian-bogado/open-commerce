package com.nsuconsulting.opencommerce.service.impl;

import com.nsuconsulting.opencommerce.model.BaseBean;

import java.util.UUID;

public abstract class AbstractBaseBeanService<T extends BaseBean> extends AbstractTimestampBeanService<T> {

	@Override
	protected T prepareToCreate(T entity) {
		entity.setUuid(UUID.randomUUID().toString());
		return super.prepareToCreate(entity);
	}
}
