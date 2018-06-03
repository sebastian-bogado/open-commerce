package com.nsuconsulting.opencommerce.commons.dao;

import com.nsuconsulting.opencommerce.commons.model.BaseBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface BaseBeanDao<T extends BaseBean> extends TimestampBeanDao<T>, JpaRepository<T, Long> {
	Optional<T> findById(Long id);
	void deleteByUuid(String uuid);
}
