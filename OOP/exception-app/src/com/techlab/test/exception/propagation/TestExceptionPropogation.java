package com.techlab.test.exception.propagation;

public class TestExceptionPropogation {
	public static void main(String args[]) throws Exception{
//		try {
			m1();
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		System.out.println("end of main");
		
	}

	public static void m1() throws Exception{
		System.out.println("inside m1");
		m2();
	}

	public static void m2() throws Exception {
		System.out.println("inside m2");
		m3();
	}

	public static void m3() throws Exception {
		System.out.println("inside m3");
		throw new Exception();
	}
}
