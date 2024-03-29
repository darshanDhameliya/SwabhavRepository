package com.techlab.dip.solution.test;

import com.techlab.dip.solution.DbLogger;
import com.techlab.dip.solution.FileLogger;
import com.techlab.dip.solution.TaxCalculator;

public class TaxCalculatorTest {

	public static void main(String args[]) {
		TaxCalculator taxCalculator = new TaxCalculator(new DbLogger());
		taxCalculator.calculateTax(0, 0);

		taxCalculator = new TaxCalculator(new FileLogger());
		taxCalculator.calculateTax(0, 0);
		
		System.out.println("calculate tax : "+taxCalculator.calculateTax(200, 20));
	}
}
