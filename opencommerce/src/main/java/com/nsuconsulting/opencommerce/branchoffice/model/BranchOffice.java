package com.nsuconsulting.opencommerce.branchoffice.model;

import com.nsuconsulting.opencommerce.utils.model.LogicalDeleteableBean;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class BranchOffice extends LogicalDeleteableBean {

	@NotNull
	@NotEmpty
	@Setter(AccessLevel.NONE)
	private String name;
	@NotNull
	@NotEmpty
	@Setter(AccessLevel.NONE)
	private String normalizedName;
	@NotNull
	@NotEmpty
	private String street;
	@NotNull
	@Min(0)
	private Long number;
	private String apartment;

	public void setName(final String name) {
		this.name = name;
		this.normalizedName = name.trim().toLowerCase();
	}

}
