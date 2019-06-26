package com.techlab.singleton.simple.factory.test;

import com.techlab.singleton.simple.factory.AutoMobileFactory;
import com.techlab.singleton.simple.factory.AutoType;
import com.techlab.singleton.simple.factory.IAutoMobile;

public class AutoMobileTest {
	public static void main(String args[]) {
		AutoMobileFactory factory = AutoMobileFactory.getInstance();
		IAutoMobile auto=factory.make(AutoType.AUDI);
		
		auto.start();
		auto.stop();
		
		System.out.println("class name : "+auto.getClass().getSimpleName());
	}
}
