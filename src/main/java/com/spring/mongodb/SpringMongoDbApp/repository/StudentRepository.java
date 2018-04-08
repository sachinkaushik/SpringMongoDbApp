package com.spring.mongodb.SpringMongoDbApp.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.mongodb.SpringMongoDbApp.document.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{

}
