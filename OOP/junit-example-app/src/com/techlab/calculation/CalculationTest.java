package com.techlab.calculation;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculationTest {
	private Calculation calculation = new Calculation();

	@Test
	public void findMaxNumber_ValueIsIntArray_ResultIs4() {
		System.out.println("test case find max");
		int actual = calculation.findMaxNumber(new int[] { 1, 3, 4, 2 });
		int excepted = 4;
		assertEquals(excepted, actual);
	}

	@Test
	public void findCube_ValueIs3_ResultIs27() {
		System.out.println("test case cube");
		int actual = calculation.cube(3);
		int excepted = 27;
		assertEquals(excepted, actual);
	}

	@Test(expected = ArithmeticException.class)
	public void checkNegativeValue_PossitiveValue_ArithmeticExceptionThrow() {
		System.out.println("test case negative value");
		calculation.checkNegativeValue(-1);
	}
}