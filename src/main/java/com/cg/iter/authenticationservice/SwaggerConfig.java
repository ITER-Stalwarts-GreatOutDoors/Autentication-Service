package com.cg.iter.authenticationservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket swaggerConfiguration() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/auth/*"))
				.apis(RequestHandlerSelectors.basePackage("com.cg.iter"))
				.build()
				.apiInfo(apiDetails());
	}
	

	@SuppressWarnings("deprecation")
	private ApiInfo apiDetails() {
		return new ApiInfo(
				
				"Authentication API", 
				"Authenticate, add, delete and edit users", 
				"1.0", 
				"Free to use", 
				"Iter", 
				"", 
				"iter.com"
				
				);
	}
}
