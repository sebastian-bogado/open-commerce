package com.nsu.duhire.webapi.authserver.model;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@Data
public abstract class TimestampBean {
	private Date creationDate;
	private Date lastUpdate;
}
