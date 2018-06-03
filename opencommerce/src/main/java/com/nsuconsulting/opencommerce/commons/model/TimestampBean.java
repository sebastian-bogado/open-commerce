package com.nsuconsulting.opencommerce.commons.model;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
public abstract class TimestampBean {
	private LocalDateTime creationDate;
	private LocalDateTime lastUpdate;
}
