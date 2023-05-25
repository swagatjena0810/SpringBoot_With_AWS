package com.swagat.WelcomeApp;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="GREETAPI")
public interface GreetFeignClient {
	
	@GetMapping("/greet")
	public String invokeGreetApi();
}
