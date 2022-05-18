package com.spring.boot.sportyshoes;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class SportyshoesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportyshoesApplication.class, args);
		System.out.println("Welcome to SportyShoes section!!");
	}

	 @Bean
	    public Docket swaggerConfiguration() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("com.spring.boot.sportyshoes"))
	                .build()
	                .apiInfo(apiDetails());
	    }
	    
	    private ApiInfo apiDetails() {
	        return new ApiInfo(
	                "Sportyshoes API",
	                "Spring Boot REST API for sportyshoes.com",
	                "1.0",
	                "Free to use",
	                new springfox.documentation.service.Contact("Rahul Rana", "https://github.com/rahulpersie66/", "rahulpersie66@gmail.com"),
	                "API License",
	                "https://github.com/rahulpersie66/",
	                Collections.emptyList()
	     
	    );
	  }
	
}


