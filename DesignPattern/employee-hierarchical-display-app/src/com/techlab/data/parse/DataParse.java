package com.techlab.data.parse;

import java.util.ArrayList;
import java.util.HashSet;

import com.techlab.data.loaded.DataLoaded;
import com.techlab.employee.Employee;

public class DataParse {
	private HashSet<String> strings = new HashSet<String>();
	private Integer id;
	private String name;
	private String designation;
	private Integer managerId;
	private String dateOfJoin;
	private Integer salary;
	private Integer commision;
	private Integer department;

	public DataParse(DataLoaded dataLoaded, String path) {
		strings = dataLoaded.dataLoaded(path);
	}

	public ArrayList<Employee> getData() {
		ArrayList<Employee> employees = new ArrayList<Employee>();

		for (String string : strings) {
			dataSplit(string);
			employees.add(new Employee(id, name, designation, managerId, dateOfJoin, salary, commision, department));
		}
		return employees;
	}

	public void dataSplit(String string) {
		String[] data = string.split(",");

		id = Integer.parseInt(data[0]);
		name = data[1];
		designation = data[2];
		dateOfJoin = data[4];
		salary = Integer.parseInt(data[5]);
		department = Integer.parseInt(data[7]);

		managerId = null;
		if (!data[3].equals("NULL"))
			managerId = Integer.parseInt(data[3]);
		commision = null;
		if (!data[6].equals("NULL"))
			commision = Integer.parseInt(data[6]);
	}

}
