package com.techlab.factory.method.part.three.test;

import java.lang.reflect.InvocationTargetException;

import com.techlab.factory.method.part.three.IAutoMobile;
import com.techlab.factory.method.part.three.IAutoMobileFactory;
import com.techlab.factory.method.part.three.Proparties;
import com.techlab.factory.method.part.three.TeslaFactory;

public class AutoMobileTest {
	public static void main(String args[]) throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Proparties proparties=new Proparties();
		Class<?> c=Class.forName(proparties.getProparties());
		IAutoMobileFactory factory =(IAutoMobileFactory) c.getDeclaredMethod("getInstance", null).invoke(null, null);
		IAutoMobile auto=factory.make();
		
		auto.start();
		auto.stop();
		
		System.out.println("class name : "+auto.getClass().getSimpleName());
	}
}
