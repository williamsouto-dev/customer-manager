package com.example.customermanager;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="Customer Management Service"))
public class CustomerManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerManagerApplication.class, args);
	}
}
