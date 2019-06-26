package com.techlab.analyze;

import java.util.ArrayList;
import java.util.HashMap;

import com.techlab.employee.Employee;

public class Analyze {
	private ArrayList<Employee> employees;
	private Employee maxSalEmployee;

	public Analyze(ArrayList<Employee> employees) {
		this.employees = employees;
	}

	public Employee maximumSalaryEmployee() {
		for (Employee employee : employees) {

			if (checkNullValue(maxSalEmployee))
				maxSalEmployee = employee;

			if (maxSalEmployee.getSalary() < employee.getSalary())
				maxSalEmployee = employee;
		}
		return maxSalEmployee;
	}

	public boolean checkNullValue(Employee employee) {
		if (employee == null)
			return true;
		return false;
	}

	public HashMap<String, Integer> totalEmployeeDesignationWise() {
		HashMap<String, Integer> designationCount = new HashMap<String, Integer>();
		String employeeDesignation;

		for (Employee employee : employees) {
			employeeDesignation=employee.getDesignation();
			
			if (designationCount.containsKey(employeeDesignation)) {

				designationCount.put(employeeDesignation, incrementCount((int) designationCount.get(employeeDesignation)));
				continue;
			}
			designationCount.put(employeeDesignation, 1);

		}
		return designationCount;
	}

	public HashMap<Integer, Integer> totalEmployeeDepartmentWise() {
		HashMap<Integer, Integer> departmentCount = new HashMap<Integer, Integer>();
		int employeeDepartment;
		
		for (Employee employee : employees) {
			employeeDepartment=employee.getDepartment();
			
			if (departmentCount.containsKey(employeeDepartment)) {
				departmentCount.put(employeeDepartment, incrementCount((int) departmentCount.get(employeeDepartment)));
				continue;
			}
			departmentCount.put(employeeDepartment, 1);
		}
		return departmentCount;
	}

	public int incrementCount(int count) {
		return count + 1;
	}

	public ArrayList<Employee> getEmployees() {
		return employees;
	}
}
