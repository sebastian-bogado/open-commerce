package com.nsuconsulting.opencommerce.dao;

import com.nsuconsulting.opencommerce.model.TimestampBean;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface TimestampBeanDao<T extends TimestampBean> {
}
