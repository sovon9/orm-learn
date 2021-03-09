package com.cognizant.ormlearn;

import java.util.Date;
import java.util.Set;

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
 * One to Many Relationships using testGetEmployee
 *
 */
@SpringBootApplication
public class OrmLearnApplication10 {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication10.class);

	private static EmployeeService employeeService;
	private static DepartmentService departmentService;
	private static SkillService skillService;

	/**
	 *   fetch both department and employee
	 *   
	 *   get a department using departmentService.get()
	 *   
	 *   Log the returned department and department.getEmployeeList()
	 */
	private static void testGetDepartment() {

		LOGGER.info("Start");
		Department department = departmentService.get(1);
		Set<Employee> employees=department.getEmployeeList();
		LOGGER.debug("Employees:{}",employees);
		LOGGER.info("End");
	}


	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication10.class, args);
		employeeService = context.getBean(EmployeeService.class);
		departmentService = context.getBean(DepartmentService.class);
		skillService = context.getBean(SkillService.class);

		LOGGER.info("Inside main");
		testGetDepartment();
		// testAddEmployee();
		// testUpdateEmployee();
	}

}
