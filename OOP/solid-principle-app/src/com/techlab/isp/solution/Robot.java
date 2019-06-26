package com.techlab.isp.solution;

public class Robot implements IWorkable {

	@Override
	public void startWork() {
		System.out.println("robot start work");
	}

	@Override
	public void stopWork() {
		System.out.println("robot stop work");
	}

}
