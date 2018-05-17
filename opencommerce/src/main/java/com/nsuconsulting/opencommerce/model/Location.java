package com.nsuconsulting.opencommerce.model;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Location extends LogicalDeleteableBean {
	private String name;
	private String description;
	private String address;
}
