package com.techlab.simple.factory;

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
