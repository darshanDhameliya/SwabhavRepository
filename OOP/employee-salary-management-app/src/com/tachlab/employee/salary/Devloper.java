package com.tachlab.employee.salary;

public class Devloper extends EmployeeSalary{

	private float INCREMENT_PA=0.4f;
	private float INCREMENT_BONUS=0.3f;
	private float PA;
	private float bonus;
	
	public Devloper(String name, int employeeNo, int basicSalary) {
		super(name, employeeNo, basicSalary);
	}

	public float getPA() {
		return PA;
	}

	public float getBonus() {
		return bonus;
	}

	@Override
	public void calculateEmployeeSalary() {
		PA=basicSalary*INCREMENT_PA;
		bonus=basicSalary*INCREMENT_BONUS;
		
		totalSalary=basicSalary+PA+bonus;
	}

}
