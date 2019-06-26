package com.techlab.factory.method.part.two.test;

import com.techlab.factory.method.part.two.IAutoMobile;
import com.techlab.factory.method.part.two.IAutoMobileFactory;
import com.techlab.factory.method.part.two.TeslaFactory;

public class AutoMobileTest {
	public static void main(String args[]) {
		IAutoMobileFactory factory =TeslaFactory.getInstance();
		IAutoMobile auto=factory.make();
		
		auto.start();
		auto.stop();
		
		System.out.println("class name : "+auto.getClass().getSimpleName());
	}
}
