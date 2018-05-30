package com.nsuconsulting.opencommerce.utils.dao;

import com.nsuconsulting.opencommerce.utils.model.LogicalDeleteableBean;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface LogicalDeleteableBeanDao<T extends LogicalDeleteableBean> extends BaseBeanDao<T>{
	List<T> findAllByActiveIsTrue();
	List<T> findAllByActiveIsFalse();
}
