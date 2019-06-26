package com.techlab.autoboxing.example;

public class AutoBoxingTest {
	public static void main(String args[])
	{
		Integer i=new Integer(10);
		int j=1;

		AutoBoxing.Boxing(i, j);
		AutoBoxing.UnBoxing(i, j);
	}
}
