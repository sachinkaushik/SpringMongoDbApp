package com.spring.mongodb.SpringMongoDbApp.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

//@Component
@Document(collection= "students")
public class Student {

	@Id
	private Integer studentId;
	
	private String name;
	
	private String course;
	
	//@Autowired
	private Address address;

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void show(){
		System.out.println("hey.. im student");
		address.showAddrss();
	}
	
}
