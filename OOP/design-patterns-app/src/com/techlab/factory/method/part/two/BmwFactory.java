package com.techlab.factory.method.part.two;

public class BmwFactory implements IAutoMobileFactory {

	private static BmwFactory instance;

	private BmwFactory() {
	}

	@Override
	public IAutoMobile make() {
		return new Bmw();
	}

	public static BmwFactory getInstance() {
		if (instance == null)
			instance = new BmwFactory();
		return instance;
	}
}
