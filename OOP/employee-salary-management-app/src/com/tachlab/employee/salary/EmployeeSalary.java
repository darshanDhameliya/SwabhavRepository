package com.tachlab.employee.salary;


abstract public class EmployeeSalary {
	private String name;
	private int employeeNo;
	protected int basicSalary;
	protected float totalSalary;
	
	public EmployeeSalary(String name,int employeeNo,int basicSalary) {
		this.name=name;
		this.employeeNo=employeeNo;
		this.basicSalary=basicSalary;
	}

	public String getName() {
		return name;
	}
	public int getEmployeeNo() {
		return employeeNo;
	}
	public int getBasicSalary() {
		return basicSalary;
	}
	public float getTotalSalary() {
		return totalSalary;
	}
	public abstract void calculateEmployeeSalary();

	
	
}
