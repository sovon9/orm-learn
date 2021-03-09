package com.cognizant.ormlearn;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;

/**
 * 
 * Many to One Relationships using testGetEmployee
 *
 */
@SpringBootApplication
public class OrmLearnApplication9 {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication9.class);

	private static EmployeeService employeeService;
	private static DepartmentService departmentService;
	private static SkillService skillService;

	/**
	 * gets the employee with id 1 and displays the employee details and department
	 * details.
	 */
	private static void testGetEmployee() {

		LOGGER.info("Start");
		Employee employee = employeeService.get(1);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.info("End");
	}

	/**
	 * adds a new employee data into DB with an existing department id
	 */
	private static void testAddEmployee() {
		Employee e = new Employee();
		e.setName("ss");
		e.setSalary(10000d);
		e.setPermanent(true);
		e.setDateOfBirth(new Date(20 / 11 / 20));
		Department department = departmentService.get(1);
		e.setDepartment(department);
		employeeService.save(e);
		LOGGER.debug("Employee:{}", e);
	}

	/*
	 * update an existing employee department by getting an employee instance based
	 * on employee id using employeeService.get() method
	 * 
	 * Get a department based on department id using departmentService
	 * 
	 * Set the department in employee based on the department obtained
	 */
	private static void testUpdateEmployee() {
		Employee e = employeeService.get(2);
		Department department = departmentService.get(3);
		LOGGER.debug("Department before save:{}", e.getDepartment());
		e.setDepartment(department);
		employeeService.save(e);
		LOGGER.debug("Employee:{}", e);
		LOGGER.debug("Department after save:{}", e.getDepartment());
	}

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication9.class, args);
		employeeService = context.getBean(EmployeeService.class);
		departmentService = context.getBean(DepartmentService.class);
		skillService = context.getBean(SkillService.class);

		LOGGER.info("Inside main");
		// testGetEmployee();
		// testAddEmployee();
		testUpdateEmployee();
	}

}
