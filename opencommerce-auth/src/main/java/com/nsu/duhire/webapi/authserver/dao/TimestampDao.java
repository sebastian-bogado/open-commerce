package com.nsu.duhire.webapi.authserver.dao;

import com.nsu.duhire.webapi.authserver.model.TimestampBean;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface TimestampDao<T extends TimestampBean> {
}
