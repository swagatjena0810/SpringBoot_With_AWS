package com.swagat.WelcomeApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@Autowired
	private GreetFeignClient greetClient;
	
	@Value("${msgg}")
	private String msgg;
	
	@GetMapping("/welcome")
	public String Welcome() {
		String greetResp=greetClient.invokeGreetApi();
		return greetResp+msgg;
	}

}
