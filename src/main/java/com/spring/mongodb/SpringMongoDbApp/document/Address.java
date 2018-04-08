package com.spring.mongodb.SpringMongoDbApp.document;

//@Component
public class Address {

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
