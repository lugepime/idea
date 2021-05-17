package com.idea.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2 
public class SwaggerConfig {
	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				//.paths(PathSelectors.ant("/api/*"))
				.apis(RequestHandlerSelectors.basePackage("com.idea")).paths(PathSelectors.any()).build()
				.useDefaultResponseMessages(true)
				.apiInfo(getApiInfo());
	}

	private ApiInfo getApiInfo() {
		return new ApiInfo("HR-API", // NAME
				"<p><strong>Human Resources</strong> <i></p>", // DESCRIPTION
				"V. 1.0", // VERSION
				"TERMS OF SERVICE URL", // TERMS OF SERVICE URL
				new Contact("Luis Gerardo Pino Mendoza", "https://github.com/lugepime3/Caliban", "lugepime3@gmail.com"), "", // LISENSE
				"" // TERMS OF LICENSE URL
		);
	}

}
