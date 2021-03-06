package com.techlab.dip.violution.test;

import com.techlab.dip.violution.LogType;
import com.techlab.dip.violution.TaxCalculator;

public class TaxCalculatorTest {

	public static void main(String args[]) {
		TaxCalculator taxCalculator = new TaxCalculator(LogType.DB);
		taxCalculator.calculateTax(0, 0);

		taxCalculator = new TaxCalculator(LogType.FILE);
		taxCalculator.calculateTax(0, 0);
		
		System.out.println("calculate tax : "+taxCalculator.calculateTax(200, 20));
	}
}
