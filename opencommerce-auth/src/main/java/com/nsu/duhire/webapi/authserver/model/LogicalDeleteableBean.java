package com.nsu.duhire.webapi.authserver.model;

import lombok.Data;

import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public abstract class LogicalDeleteableBean extends BaseBean {
	private Boolean active;
}
