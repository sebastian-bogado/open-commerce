package com.nsuconsulting.opencommerce.commons.dao;

import com.nsuconsulting.opencommerce.commons.model.TimestampBean;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface TimestampBeanDao<T extends TimestampBean> {
}
