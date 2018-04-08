package com.spring.mongodb.SpringMongoDbApp.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mongodb.SpringMongoDbApp.document.Address;
import com.spring.mongodb.SpringMongoDbApp.document.Student;
import com.spring.mongodb.SpringMongoDbApp.dto.StudentDto;
import com.spring.mongodb.SpringMongoDbApp.repository.StudentRepository;

@RestController
public class StudentController {

	@Autowired
	private StudentRepository studentRespository;
	
	@RequestMapping(value="addStudent", method= RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addStudent(@RequestBody StudentDto studentdto){
		
		Student student = new Student();
		student.setName(studentdto.getName());
		student.setCourse(studentdto.getCourse());
		student.setStudentId(studentdto.getStudentId());
		
		Address add = new Address();
		add.setId(studentdto.getAddress().getId());
		add.setCity(studentdto.getAddress().getCity());
		add.setState(studentdto.getAddress().getState());
		student.setAddress(add);
		Student newStudent = studentRespository.save(student);
		System.out.println(newStudent);
		
		return new ResponseEntity<>(newStudent, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="getStudents", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getStudents(){
		return new ResponseEntity<>(studentRespository.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value="getStudentById/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getStudentById(@PathVariable Integer id){
		System.out.println("getStudentById");
		return new ResponseEntity<>(studentRespository.findOne(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="updateStudentById/{id}", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateStudentById(@RequestBody StudentDto studentdto,  @PathVariable Integer id){
		Student student = studentRespository.findOne(id);
		if(Objects.nonNull(student)){
			if(Objects.nonNull(studentdto.getName()) && !StringUtils.isEmpty(studentdto.getName()))
				student.setName(studentdto.getName());
			if(Objects.nonNull(studentdto.getCourse()) && !StringUtils.isEmpty(studentdto.getCourse()))
				student.setName(studentdto.getCourse());
			
			if(Objects.nonNull(student.getAddress())){
				if(Objects.nonNull(studentdto.getAddress().getCity()) && !StringUtils.isEmpty(studentdto.getAddress().getCity())){
					student.getAddress().setCity(studentdto.getAddress().getCity());
				}
				if(Objects.nonNull(studentdto.getAddress().getState()) && !StringUtils.isEmpty(studentdto.getAddress().getState())){
					student.getAddress().setState(studentdto.getAddress().getState());
				}
			}else{
				Address address = new Address();
				if(Objects.nonNull(studentdto.getAddress().getCity()) && !StringUtils.isEmpty(studentdto.getAddress().getCity())){
					address.setCity(studentdto.getAddress().getCity());
				}
				if(Objects.nonNull(studentdto.getAddress().getState()) && !StringUtils.isEmpty(studentdto.getAddress().getState())){
					address.setState(studentdto.getAddress().getState());
				}
				student.setAddress(address);
			}
		}
		
		return new ResponseEntity<>(studentRespository.save(student), HttpStatus.OK);
	}
	
	@RequestMapping(value="deleteStudentById/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteStudentById(@PathVariable Integer id){
		studentRespository.delete(id);
		return new ResponseEntity<>("deleted successfully..", HttpStatus.OK);
	}
}
