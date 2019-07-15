package com.techlab.employee;

import java.util.HashMap;

public class Employee {

	private Integer id;
	private String name;
	private String designation;
	private Integer managerId;
	private String dateOfJoin;
	private Integer salary;
	private Integer commision;
	private Integer department;
	private static HashMap<Integer, Integer> employeeList=new HashMap<Integer,Integer>();

	public Employee(Integer id, String name, String designation, Integer managerId, String dateOfJoin, Integer salary,
			Integer commision, Integer department) {
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.managerId = managerId;
		this.dateOfJoin = dateOfJoin;
		this.salary = salary;
		this.commision = commision;
		this.department = department;
		
		employeeList.put(this.id, this.managerId);
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDesignation() {
		return designation;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public String getDateOfJoin() {
		return dateOfJoin;
	}

	public Integer getSalary() {
		return salary;
	}

	public Integer getCommision() {
		return commision;
	}

	public Integer getDepartment() {
		return department;
	}

	public static void displayXml()
	{
		System.out.println(employeeList);
	}
}
