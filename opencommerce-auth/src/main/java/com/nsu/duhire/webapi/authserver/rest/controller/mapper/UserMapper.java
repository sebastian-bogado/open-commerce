package com.nsu.duhire.webapi.authserver.rest.controller.mapper;

import com.nsu.duhire.webapi.authserver.model.User;
import com.nsu.duhire.webapi.authserver.rest.controller.dto.CreateAdminUserRequest;
import ma.glasnost.orika.MapperFactory;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements OrikaMapperFactoryConfigurer {
	@Override
	public void configure(MapperFactory mapperFactory) {
		configureUserWithCreateClientUserRequest(mapperFactory);
	}

	private void configureUserWithCreateClientUserRequest(MapperFactory mapperFactory) {
		mapperFactory.classMap(User.class, CreateAdminUserRequest.class)
				.byDefault()
				.register();
	}
}