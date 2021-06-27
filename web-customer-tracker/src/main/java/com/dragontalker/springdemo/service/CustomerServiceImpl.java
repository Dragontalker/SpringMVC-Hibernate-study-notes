package com.dragontalker.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dragontalker.springdemo.dao.CustomerDAO;
import com.dragontalker.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	// need to inject customer dao
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

}
