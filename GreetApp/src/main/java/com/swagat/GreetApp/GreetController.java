package com.swagat.GreetApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {
	
	@Autowired
	private Environment env;
	
	@Value("${msg}")
	private String msg;
	
	@GetMapping("/greet")
	public String greet() {
		String port=env.getProperty("server.port");
		return "("+port+")"+msg;
	}
}
