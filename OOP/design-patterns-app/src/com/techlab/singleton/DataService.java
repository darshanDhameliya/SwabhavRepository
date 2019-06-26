package com.techlab.singleton;

public class DataService {
	private static DataService instance;

	private DataService() {
		System.out.println("data service is create");
	}

	public void doSomething() {
		System.out.println("work done by : " + this.hashCode());
	}

	public static DataService getInstance() {
		if (instance == null)
			instance = new DataService();
		return instance;
	}
}
