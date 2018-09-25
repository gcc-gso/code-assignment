/**
 * 
 */
package org.gso.codeassignment.config;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author AhmedSalem
 *
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("org.gso.codeassignment.controller")).paths(regex("/todo.*"))
				.build()
	            .apiInfo(getApiInfo());
	}

	private ApiInfo getApiInfo() {
	    return new ApiInfo(
	            "TodoList Application",
	            "TodoList spring boot rest application for Gso assignment",
	            "1.0",
	            "TERMS OF SERVICE URL",
	            new Contact("Ahmed Salem","","ahmed.elsayed.salem@gmail.com"),
	            "Apache License Version 2.0",
	            "https://www.apache.org/licenses/LICENSE-2.0",
	            Collections.emptyList()
	    );
	}
}
