package com.techlab.analyze;

import java.util.ArrayList;
import java.util.HashMap;

import com.techlab.employee.Employee;

public class Analyze {
	private ArrayList<Employee> employeeList;
	private Employee maxSalEmployee;

	public Analyze(ArrayList<Employee> employees) {
		this.employeeList = employees;
	}

	public Employee maximumSalaryEmployee() {
		for (Employee employee : employeeList) {

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

		for (Employee employee : employeeList) {
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
		
		for (Employee employee : employeeList) {
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
		return employeeList;
	}
}
