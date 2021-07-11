package com.dragontalker.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dragontalker.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	// define field for entitymanager
	private EntityManager entityManager;
	
	// set up constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
