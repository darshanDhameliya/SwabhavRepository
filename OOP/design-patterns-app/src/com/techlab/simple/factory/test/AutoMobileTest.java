package com.techlab.simple.factory.test;

import com.techlab.simple.factory.AutoMobileFactory;
import com.techlab.simple.factory.AutoType;
import com.techlab.simple.factory.IAutoMobile;

public class AutoMobileTest {
	public static void main(String args[]) {
		AutoMobileFactory autoMobileFactory = new AutoMobileFactory();
		IAutoMobile autoMobile=autoMobileFactory.make(AutoType.BMW);
		
		autoMobile.start();
		autoMobile.stop();
	}
}
