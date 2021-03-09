package com.cognizant.ormlearn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.service.EmployeeServiceHQL;

/**
 * 
 * Many to One Relationships using testGetEmployee
 *
 */
@SpringBootApplication
public class OrmLearnApplication12 {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication12.class);

	private static EmployeeServiceHQL employeeServiceHQL;

	public static void testGetAllPermanentEmployees() {

		LOGGER.info("Start");
		List<Employee> employees = employeeServiceHQL.getAllPermanentEmployees();
		LOGGER.debug("Permanent Employees:{}", employees);
		employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList()));
		LOGGER.info("End");

	}
	
	public static void testGetAverageSalary()
	{
		LOGGER.info("Start");
		double avgSal=employeeServiceHQL.getAverageSalary(1); 
		LOGGER.debug("average salary:{}", avgSal);
	}
	
	public static void testGetAllEmployeesNative()
	{
		LOGGER.info("Start");
		List<Employee> employees=employeeServiceHQL.getAllEmployeesNative(); 
		LOGGER.debug("Employees:{}", employees);
	}

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication12.class, args);
		employeeServiceHQL = context.getBean(EmployeeServiceHQL.class);

		LOGGER.info("Inside main");

		testGetAllPermanentEmployees();
		//testGetAverageSalary();
		//testGetAllEmployeesNative();
	}

}
