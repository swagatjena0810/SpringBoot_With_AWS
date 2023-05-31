package com.swagat.Spring_OktaAuth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
	
	@GetMapping("/")
	public String Welcome() {
		return "Welcome to okta auth test app";
	}
}
