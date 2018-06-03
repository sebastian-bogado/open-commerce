package com.nsuconsulting.opencommerce.commons.service;

import com.nsuconsulting.opencommerce.commons.model.LogicalDeleteableBean;

public class AbstractLogicalDeleteableBeanService<T extends LogicalDeleteableBean> extends AbstractBaseBeanService<T> {
	@Override
	public T prepareToCreate(T bean) {
		bean.setActive(true);
		return super.prepareToCreate(bean);
	}
}
