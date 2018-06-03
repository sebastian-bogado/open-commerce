package com.nsuconsulting.opencommerce.product.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
public class Picture {
	@Id
	@GeneratedValue
	private Long id;
	@NotNull
	@NotEmpty
	private String path;
	@ManyToOne(fetch = FetchType.LAZY)
	private Product product;

	public Picture(String picture) {
		this.path = picture;
	}

}
