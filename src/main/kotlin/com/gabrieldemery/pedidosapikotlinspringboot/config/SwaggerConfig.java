package com.gabrieldemery.pedidosapikotlinspringboot.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.gabrieldemery.pedidosapikotlinspringboot"))
				.paths(regex(".*"))
				.build()
				.apiInfo(this.metaInfo());
	}

	private ApiInfo metaInfo() {

		ApiInfo apiInfo = new ApiInfo(
			"API de Pedidos",
			"API REST de Pedidos, desenvolvido em Kotlin, com Spring Boot."
			, "1.0",
			"Terms of Service",
			new Contact("Gabriel D'Emery", "https://gabrieldemery.com", "falecomigo@gabrieldemery.com"),
			"Apache License Version 2.0", "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
		);

		return apiInfo;
	}

}
