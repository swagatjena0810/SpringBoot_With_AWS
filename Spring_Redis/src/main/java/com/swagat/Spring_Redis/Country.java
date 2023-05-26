package com.swagat.Spring_Redis;

import java.io.Serializable;

import lombok.Data;

//The data to be stored should implements Serializable interface
//Serializable is markup interface
//Markup interface means no method
//this is special identity
@Data
public class Country  implements Serializable{

	private Integer sno;
	private String name;
	private String countryCode;

}
