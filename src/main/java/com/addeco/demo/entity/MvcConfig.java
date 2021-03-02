package com.addeco.demo.entity;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer{

	@Override
	public void addResourceHandlers (ResourceHandlerRegistry registry) {
		Path productUploadDir = Paths.get("./product-logos");
		String productUploadPath = productUploadDir.toFile().getAbsolutePath();
		
		registry.addResourceHandler("/product-logos/**").addResourceLocations("file:/" + productUploadPath + "/");
	}
	
}
