package com.techlab.employee.hierarchy.builder;

import java.util.ArrayList;
import java.util.HashMap;

import com.techlab.data.loaded.DiskLoaded;
import com.techlab.data.parse.DataParse;
import com.techlab.employee.Employee;

public class EmployeeHierarchyBuilder {

	ArrayList<Employee> employeeList = new ArrayList<Employee>();
	Employee president = null;
	Employee supervisor = null;

	public EmployeeHierarchyBuilder(ArrayList<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public void genrateHierarchy() {
		president=findPresident();
		for (Employee employee : employeeList) {
			supervisor = null;
			for (Employee employeeSupervisor : employeeList) {
				if (!employee.equals(president) && employee.getManagerId().equals(employeeSupervisor.getId())) {
					supervisor = employeeSupervisor;
					break;
				}
			}
			if (supervisor != null)
				supervisor.addChild(employee);
		}
	}private Employee findPresident()
	{
		for (Employee employee : employeeList) {
			if (employee.getManagerId() == null) {
				return employee;
			}
		}	
		return null;
	}
	public void displayEmployeeHierarchy()
	{
		president.displayEmployeeList();
	}
}
