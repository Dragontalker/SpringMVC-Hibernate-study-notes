package com.dragontalker.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dragontalker.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
