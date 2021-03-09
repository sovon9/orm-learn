package com.cognizant.ormlearn.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dp_id")
	private int id;
	
	@Column(name = "dp_name")
	private String name;
	
	// one to many relationship btw Employee and Department
	/**
	 *  LazyInitializationException. This is because the default fetch type
	 *  for OneToMany relationship is LAZY, hibernate fetches only department details
	 *   and does not get the employee details.
	 */
	@OneToMany(mappedBy = "department") //, fetch = FetchType.EAGER
	private Set<Employee> employeeList;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Set<Employee> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(Set<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", employeeList=" + employeeList + "]";
	}	
	
}