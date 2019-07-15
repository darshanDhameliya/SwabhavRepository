package com.techlab.employee;

import java.util.ArrayList;

public class Employee {

	private Integer id;
	private String name;
	private String designation;
	private Integer managerId;
	private String dateOfJoin;
	private Integer salary;
	private Integer commision;
	private Integer department;
	private ArrayList<Employee> children = new ArrayList<Employee>();
	private String space = "\t";
	private static boolean displayPresident = true;

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

	public void setSpace(String space) {
		this.space = space;
	}

	private String getSpace() {
		return space;
	}

	public void addChild(Employee employee) {
		employee.setSpace(this.getSpace() + "\t");
		children.add(employee);
	}

	public void displayEmployeeList() {
		if (displayPresident) {
			System.out.println(this.getId()+" "+this.getName()+" "+this.getDesignation());
			displayPresident = false;
		}
		for (Employee child : children) {
			System.out.println(space+child.getId()+" "+child.getName()+" "+child.getDesignation());
			child.displayEmployeeList();
		}
	}

}
