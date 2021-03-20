package com.myWebApp.crudoperations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class MicroserviceCrudOperationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceCrudOperationsApplication.class, args);
	}


}
