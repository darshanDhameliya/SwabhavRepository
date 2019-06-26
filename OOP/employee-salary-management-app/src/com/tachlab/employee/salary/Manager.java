package com.tachlab.employee.salary;


public class Manager extends EmployeeSalary{
	private float INCREMENT_HRA=0.5f;
	private float INCREMENT_TA=0.4f;
	private float INCREMENT_DA=0.3f;
	private float HRA;
	private float TA;
	private float DA;
	public Manager(String name,int employeeNo,int basicSalary) {
		super(name,employeeNo,basicSalary);
	}
	public float getHRA() {
		return HRA;
	}
	public float getTA() {
		return TA;
	}
	public float getDA() {
		return DA;
	}

	@Override
	public void calculateEmployeeSalary() {

		HRA=basicSalary*INCREMENT_HRA;
		TA=basicSalary*INCREMENT_TA;
		DA=basicSalary*INCREMENT_DA;
		totalSalary=basicSalary+HRA+TA+DA;
	}
}
