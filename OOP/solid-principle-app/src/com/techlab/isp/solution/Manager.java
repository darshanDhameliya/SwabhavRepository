package com.techlab.isp.solution;

public class Manager implements IEatableWorkable {

	@Override
	public void startWork() {
		System.out.println("manager start work");
	}

	@Override
	public void stopWork() {
		System.out.println("manager stop work");
	}

	@Override
	public void startEat() {
		System.out.println("manager start eat");
	}

	@Override
	public void stopEat() {
		System.out.println("manager stop eat");
	}

}
