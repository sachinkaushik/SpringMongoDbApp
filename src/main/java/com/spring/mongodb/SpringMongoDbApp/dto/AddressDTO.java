package com.spring.mongodb.SpringMongoDbApp.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

public class AddressDTO {

	private Integer id;
	
	private String city;
	
	private String state;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public void showAddrss(){
		System.out.println("Hey.. Im from saharanpur");
	}
}
