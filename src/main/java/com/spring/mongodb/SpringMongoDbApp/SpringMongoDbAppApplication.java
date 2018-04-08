package com.spring.mongodb.SpringMongoDbApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.spring.mongodb.SpringMongoDbApp.document.Student;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringMongoDbAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringMongoDbAppApplication.class, args);
		//Student student = context.getBean(Student.class);
		//student.show();
	}
}
