package com.tachlab.employee.salary;

import java.io.File;
import java.io.FileWriter;

public class HtmlSalarySlip {
	private static String salarySlip;

	public static String genrateManagerSalarySlip(Manager manager) {
		salarySlip = null;
		salarySlip = "<html><head><style>table, th, td {border: 1px solid black;}</style></head>"
				+ "<body><h1>Manager Salary Slip</h1>" + "<table><tr><td>Name</td><td>" + manager.getName()
				+ "</td></tr>" + "<tr><td>Employee No.</td><td>" + manager.getEmployeeNo() + "</td></tr>"
				+ "<tr><td>Basic Salary</td><td>" + manager.getBasicSalary() + "</td></tr>" + "<tr><td>HRA</td><td>"
				+ manager.getHRA() + "</td></tr>" + "<tr><td>TA</td><td>" + manager.getTA() + "</td></tr>"
				+ "<tr><td>DA</td><td>" + manager.getDA() + "</td></tr>" + "<tr><td>Total Salary</td><td>"
				+ manager.getTotalSalary() + "</td></tr></table></body></html>\r\n";
		return salarySlip;

	}

	public static String genrateDevloperSalarySlip(Devloper devloper) {
		salarySlip = null;
		salarySlip = "<html><head><style>table, th, td {border: 1px solid black;}</style></head>"
				+ "<body><h1>Devloper Salary Slip</h1>" + "<table><tr><td>Name</td><td>" + devloper.getName()
				+ "</td></tr>" + "<tr><td>Employee No.</td><td>" + devloper.getEmployeeNo() + "</td></tr>"
				+ "<tr><td>Basic Salary</td><td>" + devloper.getBasicSalary() + "</td></tr>" + "<tr><td>PA</td><td>"
				+ devloper.getPA() + "</td></tr>" + "<tr><td>Bonus</td><td>" + devloper.getBonus() + "</td></tr>"
				+ "<tr><td>Total Salary</td><td>" + devloper.getTotalSalary() + "</td></tr></table></body></html>\r\n";
		return salarySlip;
	}

	public static String genrateTesterSalarySlip(Tester tester) {

		salarySlip = null;
		salarySlip = "<html><head><style>table, th, td {border: 1px solid black;}</style></head>"
				+ "<body><h1>Tester Salary Slip</h1>" + "<table><tr><td>Name</td><td>" + tester.getName() + "</td></tr>"
				+ "<tr><td>Employee No.</td><td>" + tester.getEmployeeNo() + "</td></tr>"
				+ "<tr><td>Basic Salary</td><td>" + tester.getBasicSalary() + "</td></tr>" + "<tr><td>Perks</td><td>"
				+ tester.getPerks() + "</td></tr>" + "<tr><td>Total Salary</td><td>" + tester.getTotalSalary()
				+ "</td></tr></table></body></html>\r\n";
		return salarySlip;
	}

	

	public static void printSalarySlip(String salarySlip, String filePath) {
		File file = new File(filePath);
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter writer = new FileWriter(file);
			writer.write(salarySlip);
			writer.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
