package com.techlab.custom.annotation.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import com.techlab.custom.annotation.CustomAnnotation;
import com.techlab.custom.annotation.MyAnnotation;

public class CustomAnnotationTest {
	public static void main(String args[]) throws NoSuchMethodException, SecurityException {

		Method[] m1 ;
		m1= CustomAnnotation.class.getMethods();
		int count = 0;
		
		for (Method method : m1) {
			if (method.getAnnotation(MyAnnotation.class)!=null) {
				count++;

				System.out.println(method.getName());
			}
		}
		System.out.println(count);
	}
}
