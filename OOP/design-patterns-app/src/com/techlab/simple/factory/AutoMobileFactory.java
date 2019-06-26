package com.techlab.simple.factory;

public class AutoMobileFactory {
	public IAutoMobile make(AutoType autoType) {
		if (autoType.equals(AutoType.BMW))
			return new Bmw();
		if (autoType.equals(AutoType.TESLA))
			return new Tesla();
		if (autoType.equals(AutoType.AUDI))
			return new Audi();
		return null;
	}
}
