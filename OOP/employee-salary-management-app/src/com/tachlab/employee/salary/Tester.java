package com.tachlab.employee.salary;

public class Tester extends EmployeeSalary{
	private float INCREMENT_PERKS=0.3f;
	private float perks;
	

	public Tester(String name, int employeeNo, int basicSalary) {
		super(name, employeeNo, basicSalary);
		
	}

	public float getPerks() {
		return perks;
	}
	@Override
	public void calculateEmployeeSalary() {

		perks=basicSalary*INCREMENT_PERKS;
		totalSalary=basicSalary+perks;
	}

}
