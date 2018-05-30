package com.nsuconsulting.opencommerce.utils.service;

import com.nsuconsulting.opencommerce.utils.model.BaseBean;

import java.util.UUID;

public class AbstractBaseBeanService<T extends BaseBean> extends AbstractTimestampBeanService<T> {

	@Override
	public T prepareToCreate(T bean) {
		bean.setUuid(UUID.randomUUID().toString());
		return super.prepareToCreate(bean);
	}

}
