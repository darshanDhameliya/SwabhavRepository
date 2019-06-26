package com.techlab.factory.method.part.three;

public class TeslaFactory implements IAutoMobileFactory {

	private static TeslaFactory instance;

	private TeslaFactory() {
	}

	@Override
	public IAutoMobile make() {
		return new Tesla();
	}

	public static TeslaFactory getInstance() {
		if (instance == null)
			instance = new TeslaFactory();
		return instance;
	}

}
