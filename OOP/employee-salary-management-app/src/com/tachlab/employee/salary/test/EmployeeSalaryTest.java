package com.tachlab.employee.salary.test;

import java.io.File;

import com.tachlab.employee.salary.ConsoleSalarySlip;
import com.tachlab.employee.salary.Devloper;
import com.tachlab.employee.salary.Manager;
import com.tachlab.employee.salary.HtmlSalarySlip;
import com.tachlab.employee.salary.Tester;

public class EmployeeSalaryTest {
	private static String salarySlip;
	public static void main(String args[]) {
		Manager manager = new Manager("darshan", 1001, 10000);
		Devloper devloper = new Devloper("vivek", 1002, 15000);
		Tester tester = new Tester("hiren", 1003, 12000);

		manager.calculateEmployeeSalary();
		salarySlip=HtmlSalarySlip.genrateManagerSalarySlip(manager);
		HtmlSalarySlip.printSalarySlip(salarySlip, "res\\manager\\"+manager.getName()+"SalarySlip.html");

		devloper.calculateEmployeeSalary();
		salarySlip=HtmlSalarySlip.genrateDevloperSalarySlip(devloper);
		HtmlSalarySlip.printSalarySlip(salarySlip, "res\\devloper\\"+devloper.getName()+"SalarySlip.html");

		tester.calculateEmployeeSalary();
		salarySlip=HtmlSalarySlip.genrateTesterSalarySlip(tester);
		HtmlSalarySlip.printSalarySlip(salarySlip, "res\\tester\\"+tester.getName()+"SalarySlip.html");
		

		ConsoleSalarySlip.displaySalarySlip(manager);
		ConsoleSalarySlip.displaySalarySlip(devloper);
		ConsoleSalarySlip.displaySalarySlip(tester);

	}


}
