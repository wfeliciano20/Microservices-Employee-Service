package com.williamfeliciano.employeeservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


@OpenAPIDefinition(
		info=@Info(
				title = "Employee Service REST API",
				description = "Employee Service REST API Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "William",
						email = "william.feliciano2@gmail.com",
						url = "http://william.feliciano.com"
				),
				license = @License(
						name = "Apache License, Version 2.0",
						url = "http://william.feliciano.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Employee Service documentation",
				url="http://william.feliciano.com"
		)
)
@SpringBootApplication
@EnableFeignClients
public class EmployeeServiceApplication {

	// RestTemplate soon will be deprecated
//	@Bean
//	public RestTemplate restTemplate(){
//		return new RestTemplate();
//	}

	// WebClient the spring team recommendation for REST communication
//	@Bean
//	public WebClient webClient(){
//		return WebClient.builder().build();
//	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
