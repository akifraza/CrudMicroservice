package com.myWebApp.service2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceSerivce2Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceSerivce2Application.class, args);
	}

}
