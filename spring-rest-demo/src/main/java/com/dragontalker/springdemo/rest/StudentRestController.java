package com.dragontalker.springdemo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dragontalker.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	// define end point for "/student" - return list of students
	@GetMapping("/students")
	public List<Student> getStudents() {
		
		return null;
	}
}
