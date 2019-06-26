package com.techlab.factory.method.part.three;

public class AudiFactory implements IAutoMobileFactory {

	private static AudiFactory instance;

	private AudiFactory() {
	}

	@Override
	public IAutoMobile make() {
		return new Audi();
	}

	public static AudiFactory getInstance() {
		if (instance == null)
			instance = new AudiFactory();
		return instance;
	}
}
