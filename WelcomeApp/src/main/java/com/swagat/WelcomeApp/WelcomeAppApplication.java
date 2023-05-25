package com.swagat.WelcomeApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class WelcomeAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(WelcomeAppApplication.class, args);
	}

}
