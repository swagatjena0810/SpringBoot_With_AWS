package com.swagat.GreetApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class GreetAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreetAppApplication.class, args);
	}

}
