package com.nsuconsulting.opencommerce.commons;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class StaticResourceConfiguration extends WebMvcConfigurerAdapter {

	@Value("${image.base.folder:/home/seebogado/Pictures/opencommerce-images/}")
	private String baseFolder;
	@Value("${image.base.server.image.path:/images/}")
	private String baseImagePath;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(baseImagePath+"**").addResourceLocations("file:"+baseFolder);
	}
}