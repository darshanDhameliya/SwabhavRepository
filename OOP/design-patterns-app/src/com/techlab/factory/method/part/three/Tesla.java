package com.techlab.factory.method.part.three;

public class Tesla implements IAutoMobile {

	@Override
	public void start() {
		System.out.println("tesla start");
	}

	@Override
	public void stop() {
		System.out.println("tesla stop");
	}

}
