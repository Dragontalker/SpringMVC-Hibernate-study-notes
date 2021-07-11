package com.dragontalker.springboot.cruddemo.dao;

import java.util.List;

import com.dragontalker.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
}
