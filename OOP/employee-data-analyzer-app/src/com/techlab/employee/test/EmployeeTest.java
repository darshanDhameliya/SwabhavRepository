package com.techlab.employee.test;

import com.techlab.analyze.Analyze;
import com.techlab.data.loaded.DiskLoaded;
import com.techlab.data.loaded.URLLoaded;
import com.techlab.data.parse.DataParse;
import com.techlab.employee.Employee;

public class EmployeeTest {

	public static void main(String args[]) {
		String urlPath="https://swabhav-tech.firebaseapp.com/emp.txt ";
		DataParse dataParse=new DataParse(new URLLoaded(),urlPath);
		
//		String diskPath="E:\\dataFile.txt";
//		DataParse dataParse=new DataParse(new DiskLoaded(),diskPath);
		
		Analyze analyze=new Analyze(dataParse.getData());
		
		
		System.out.println("--------maximum--Salary------------");
		Employee employee=analyze.maximumSalaryEmployee();
		printInfo(employee);

		System.out.println("\n\nTotal Number of Employees DesignationWise");
		System.out.println(analyze.totalEmployeeDesignationWise());

		System.out.println("\n\nTotal Number of Employees DepartmentWise");
		System.out.println(analyze.totalEmployeeDepartmentWise());
		
	}
	
	public static void printInfo(Employee employee)
	{
		System.out.println("Id : "+employee.getId());
		System.out.println("Name : "+employee.getName());
		System.out.println("Designation : "+employee.getDesignation());
		System.out.println("Manager Id : "+employee.getManagerId());
		System.out.println("Date Of Join : "+employee.getDateOfJoin());
		System.out.println("Salary : "+employee.getSalary());
		System.out.println("Commision : "+employee.getCommision());
		System.out.println("Department : "+employee.getDepartment());
	}
}
