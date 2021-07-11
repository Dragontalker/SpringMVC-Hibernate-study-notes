package com.dragontalker.springboot.cruddemo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dragontalker.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	// define field for entitymanager
	
	// set up constructor injection
	
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
