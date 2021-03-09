package com.cognizant.ormlearn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.repository.EmployeeRepositoryHQL;

@Service
public class EmployeeServiceHQL {

	@Autowired
	public EmployeeRepositoryHQL employeeRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceHQL.class);

	public List<Employee> getAllPermanentEmployees()
	{
		List<Employee> employees=employeeRepository.getAllPermanentEmployees();
		return employees;
	}
	
}
