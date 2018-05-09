package com.nsu.duhire.webapi.authserver.service.impl;

import com.nsu.duhire.webapi.authserver.model.LogicalDeleteableBean;
import lombok.Data;

@Data
public abstract class LogicalDeleteableBeanService<T extends LogicalDeleteableBean> extends BaseBeanService<T> {
	protected T prepareToCreate(T baseBean) {
		baseBean.setActive(true);
		return super.prepareToCreate(baseBean);
	}
}
