package com.techlab.singleton.test;

import com.techlab.singleton.DataService;

public class SingletonTest {
	public static void main(String args[]) {
		DataService sv1 = DataService.getInstance();
		sv1.doSomething();

		DataService sv2 = DataService.getInstance();
		sv2.doSomething();

		System.out.println("dataService 1 hashcode : " + sv1.hashCode());
		System.out.println("dataService 2 hashcode : " + sv2.hashCode());
	}
}
