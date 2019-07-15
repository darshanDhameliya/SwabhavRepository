package com.techlab.employee.xml.builder;

import java.util.ArrayList;
import java.util.HashMap;

import com.techlab.data.loaded.DiskLoaded;
import com.techlab.data.parse.DataParse;
import com.techlab.employee.Employee;

public class EmployeeXmlBuilder {

	ArrayList<Employee> employeeList = new ArrayList<Employee>();
	Employee president = null;
	Employee supervisor = null;

	public EmployeeXmlBuilder(ArrayList<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public void genrateXml() {
		
	}
}
