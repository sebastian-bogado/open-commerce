package com.nsuconsulting.opencommerce.utils.service;

import com.nsuconsulting.opencommerce.utils.model.TimestampBean;

import java.time.LocalDateTime;

public class AbstractTimestampBeanService<T extends TimestampBean> {

	public T prepareToCreate(T bean) {
		bean.setCreationDate(LocalDateTime.now());
		bean.setLastUpdate(LocalDateTime.now());
		return bean;
	}

	public T prepareToUpdate(T bean) {
		bean.setLastUpdate(LocalDateTime.now());
		return bean;
	}

}
