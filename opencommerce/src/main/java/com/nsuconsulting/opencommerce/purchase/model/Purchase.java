package com.nsuconsulting.opencommerce.purchase.model;

import com.nsuconsulting.opencommerce.utils.model.BaseBean;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
public class Purchase extends BaseBean {

	@NotNull
	private BigDecimal total;
	@NotEmpty
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "purchase")
	private List<PurchaseLine> purchaseLines;
	@NotNull
	private Long branchOfficeId;

}