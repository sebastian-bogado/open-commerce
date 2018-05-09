package com.nsu.duhire.webapi.authserver.service.impl;

import com.nsu.duhire.webapi.authserver.model.TimestampBean;

import java.util.Date;

public class TimestampBeanService<T extends TimestampBean> {
	protected T prepareToCreate(T baseBean) {
		baseBean.setCreationDate(new Date());
		baseBean.setLastUpdate(new Date());
		return baseBean;
	}

	protected T prepareToUpdate(T baseBean) {
		baseBean.setLastUpdate(new Date());
		return baseBean;
	}
}
