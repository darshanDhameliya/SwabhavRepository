package com.techlab.singleton.simple.factory;

public class AutoMobileFactory {

	private static AutoMobileFactory instance;

	private AutoMobileFactory() {
	}

	public IAutoMobile make(AutoType autoType) {
		if (autoType.equals(AutoType.BMW))
			return new Bmw();
		if (autoType.equals(AutoType.TESLA))
			return new Tesla();
		if (autoType.equals(AutoType.AUDI))
			return new Audi();
		return null;
	}

	public static AutoMobileFactory getInstance() {
		if (instance == null)
			instance = new AutoMobileFactory();
		return instance;
	}
}
