package com.tachlab.employee.salary;

public class ConsoleSalarySlip {
	public static void displaySalarySlip(Manager manager) {
		System.out.println("\n---manager---\n ");
		System.out.println("name : " + manager.getName());
		System.out.println("emp no : " + manager.getEmployeeNo());
		System.out.println("basic salary : " + manager.getBasicSalary());
		System.out.println("hra : " + manager.getHRA());
		System.out.println("ta : " + manager.getTA());
		System.out.println("da : " + manager.getDA());
		System.out.println("total salary : " + manager.getTotalSalary());
	}

	public static void displaySalarySlip(Devloper devloper) {
		System.out.println("\n---devloper---\n ");
		System.out.println("name : " + devloper.getName());
		System.out.println("emp no : " + devloper.getEmployeeNo());
		System.out.println("basic salary : " + devloper.getBasicSalary());
		System.out.println("pa : " + devloper.getPA());
		System.out.println("bonus : " + devloper.getBonus());
		System.out.println("total salary : " + devloper.getTotalSalary());
	}

	public static void displaySalarySlip(Tester tester) {
		System.out.println("\n---tester---\n ");
		System.out.println("name : " + tester.getName());
		System.out.println("emp no : " + tester.getEmployeeNo());
		System.out.println("basic salary : " + tester.getBasicSalary());
		System.out.println("perks : " + tester.getPerks());
		System.out.println("total salary : " + tester.getTotalSalary());
	}

}
