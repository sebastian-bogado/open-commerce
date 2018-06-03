package com.nsuconsulting.opencommerce.purchase.model;

import com.nsuconsulting.opencommerce.commons.model.BaseBean;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Entity
public class PurchaseLine extends BaseBean {

	@NotNull
	private Long productId;
	@NotNull
	@Min(0)
	private BigDecimal unitPrice;
	@NotNull
	@Min(0)
	private Double quantity;
	@ManyToOne(fetch = FetchType.LAZY)
	private Purchase purchase;

}
