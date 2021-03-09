package com.cognizant.ormlearn;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;

/**
 * 
 * Many to One Relationships using testGetEmployee
 *
 */
@SpringBootApplication
public class OrmLearnApplication11 {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication11.class);

	private static EmployeeService employeeService;
	private static DepartmentService departmentService;
	private static SkillService skillService;

	// Fetching Employee along with Skills
	private static void testGetEmployee() {

		LOGGER.info("Start");
		Employee employee = employeeService.get(1);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.debug("Skills:{}", employee.getSkillList());
		LOGGER.info("End");
	}

	// Add Skill to Employee
	private static void testAddSkillToEmployee() {
		// getting employee id 2 details
		Employee employee = employeeService.get(2);
		// getting skill id 2 details
		Skill skill = skillService.get(2);
		Set<Skill> skillList = employee.getSkillList();
		// adding skills to skill list
		skillList.add(skill);
		employeeService.save(employee);
	}

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication11.class, args);
		employeeService = context.getBean(EmployeeService.class);
		departmentService = context.getBean(DepartmentService.class);
		skillService = context.getBean(SkillService.class);

		LOGGER.info("Inside main");
		// testGetEmployee();
		testAddSkillToEmployee();
	}

}
