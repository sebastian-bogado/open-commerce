package com.nsuconsulting.opencommerce.commons.service;

import com.nsuconsulting.opencommerce.commons.model.BaseBean;

import java.util.UUID;

public class AbstractBaseBeanService<T extends BaseBean> extends AbstractTimestampBeanService<T> {

	@Override
	public T prepareToCreate(T bean) {
		bean.setUuid(UUID.randomUUID().toString());
		return super.prepareToCreate(bean);
	}

}
