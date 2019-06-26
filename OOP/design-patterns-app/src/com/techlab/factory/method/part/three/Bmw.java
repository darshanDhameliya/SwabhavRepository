package com.techlab.factory.method.part.three;

public class Bmw implements IAutoMobile {

	@Override
	public void start() {
		System.out.println("bmw start");
	}

	@Override
	public void stop() {
		System.out.println("bmw stop");
	}

}
