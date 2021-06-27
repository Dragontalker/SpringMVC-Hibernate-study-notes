package com.dragontalker.springdemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dragontalker.springdemo.entity.Customer;
import com.mysql.cj.xdevapi.SessionFactory;

public class CustomerDAOImpl implements CustomerDAO {
	
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

}
