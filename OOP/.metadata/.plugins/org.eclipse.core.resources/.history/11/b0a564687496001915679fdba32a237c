package com.techlab.isp.violation;

import javax.management.RuntimeErrorException;

public class Robot implements IWorker{

	@Override
	public void startWork() {
		System.out.println("robot start work");
	}

	@Override
	public void stopWork() {
		System.out.println("robot stop work");
	}

	@Override
	public void startEat() {
		throw new RuntimeErrorException(null);
	}

	@Override
	public void stopEat() {
		throw new RuntimeErrorException(null);
	}

}
