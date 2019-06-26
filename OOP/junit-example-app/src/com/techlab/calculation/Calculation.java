package com.techlab.calculation;

public class Calculation {

	public int findMaxNumber(int[] arr) {
		int max=arr[0];
		for (int value : arr) {
			if (max<value)
				max=value;
		}
		return max;
	}
	public int cube(Integer n)
	{
		return n*n*n;
	}
	public void checkNegativeValue(int value)
	{
		if(value<0)
		{
			throw new ArithmeticException();
		}
	}
}
