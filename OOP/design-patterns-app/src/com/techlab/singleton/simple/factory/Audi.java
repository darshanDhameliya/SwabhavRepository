package com.techlab.singleton.simple.factory;

public class Audi implements IAutoMobile {

	@Override
	public void start() {
		System.out.println("audi start");
	}

	@Override
	public void stop() {
		System.out.println("audi stop");
	}

}
