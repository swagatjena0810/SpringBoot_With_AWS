package com.swagat.Spring_Redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {
	
	//@Configuration-It will represent our java class as a configuration class
	//@bean  it is used to annotate the method that to be called by IOC container
	//that method is returning an object.That object will be represented as a spring bean object
	
	//I want this method to be excuted by IOC container
	//By using @Bean it tells IOC to call this method
	@Bean
	public JedisConnectionFactory jedisConn() {
		
		JedisConnectionFactory jedis= new JedisConnectionFactory();
// as both redis and application are running in same computer so we no need to set below 2 but in real time 
// application and redis will run in different computer at that time we need to set below 2 properties
		
//		jedis.setHostName(null);
//		jedis.setPort(0);
		return jedis;
	}
	
	@Bean
	public RedisTemplate<String, Country> redisTemplate(){
		
		RedisTemplate<String, Country> rt=new RedisTemplate<>();
		
		//for this redis template i need to set where the jedis connection is available
		//the jedisConn() method will establish connection withj redis server
	//the jedisConn() method will be called by Ioc container so JedisConnectionFactory object will be created
		rt.setConnectionFactory(jedisConn());
		return rt;
	}
	
}
