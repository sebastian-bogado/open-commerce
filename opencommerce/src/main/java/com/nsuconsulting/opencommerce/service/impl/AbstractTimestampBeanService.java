package com.nsuconsulting.opencommerce.service.impl;

import com.nsuconsulting.opencommerce.model.TimestampBean;

import java.util.Date;

public class AbstractTimestampBeanService<T extends TimestampBean> {

	protected T prepareToCreate(T entity) {
		entity.setCreationDate(new Date());
		entity.setLastUpdate(new Date());
		return entity;
	}

	protected T prepareToUpdate(T entity) {
		entity.setLastUpdate(new Date());
		return entity;
	}

}
