package com.spring.mongodb.SpringMongoDbApp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.mongodb.SpringMongoDbApp.document.Student;

public interface StudentRepository extends MongoRepository<Student, Integer>{

}
