package com.cg.iter.authenticationservice.conifg;

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
	public Docket swaggerConfigurationAuth() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("Authentication")
				.select()
				.paths(PathSelectors.ant("/app/auth/*"))
				.apis(RequestHandlerSelectors.basePackage("com.cg.iter.authenticationservice"))
				.build()
				.apiInfo(apiDetails());
	}
	
	@Bean
	public Docket swaggerConfigurationAdmin() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("Admin")
				.select()
				.paths(PathSelectors.ant("/app/admin/*"))
				.apis(RequestHandlerSelectors.basePackage("com.cg.iter.authenticationservice"))
				.build()
				.apiInfo(apiDetails());
	}
	
	@Bean
	public Docket swaggerConfigurationProductMaster() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("Product Master")
				.select()
				.paths(PathSelectors.ant("/app/master/*"))
				.apis(RequestHandlerSelectors.basePackage("com.cg.iter.authenticationservice"))
				.build()
				.apiInfo(apiDetails());
	}
	
	@Bean
	public Docket swaggerConfigurationUser() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("User")
				.select()
				.paths(PathSelectors.ant("/app/user/*"))
				.apis(RequestHandlerSelectors.basePackage("com.cg.iter.authenticationservice"))
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
