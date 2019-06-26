package com.techlab.my.exception;

public class MyExceptionTest {
	public static void main(String args[]) {
		try {
			checkName("darshan");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void checkName(String name) throws MyException {
		if (!name.equalsIgnoreCase("darshan")) {
			throw new MyException("name is not same");
		}
		System.out.println("name is same");
	}

}
