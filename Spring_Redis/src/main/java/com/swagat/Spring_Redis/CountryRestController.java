package com.swagat.Spring_Redis;

import java.util.Collection;
import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryRestController {
	
	private HashOperations<String, Integer, Country> opsForHash;
	
	//written a constructor
	//it will be called by IOC container as it is represented as a spring bean by @RestController annotation
	//as it is represented as a spring bean, ioc container will create object for this class
	//inorder to create the object for class, it is going to call constructor
	
	public CountryRestController(RedisTemplate<String, Country> rt) {		
		 this.opsForHash=rt.opsForHash();
	}
	
	
	@PostMapping("/addcountry")
	public String addCountry(@RequestBody Country country) {
		opsForHash.put("COUNTRIES", country.getSno(), country);
		return "Country Added";	
	}
	
	@GetMapping("/countries")
	public Collection<Country> getCountries(){
		Map<Integer, Country> entries = opsForHash.entries("COUNTRIES");
		Collection<Country> values = entries.values();
		return values;
	}

}
