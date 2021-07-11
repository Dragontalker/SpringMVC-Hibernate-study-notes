package com.dragontalker.springboot.thymeleafdemo.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dragontalker.springboot.thymeleafdemo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	// load employee data
	
	private List<Employee> employees;
	
	@PostConstruct
	private void loadData() {
		
		// create employees
		
		// create the list
		
		// add to the list
	}
	
	// add mapping for "/list"
	
}
