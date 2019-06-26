package com.techlab.reflaction.test;


public class ReflactionTest {
	public static void main(String args[])
	{
		Reflaction reflact=new Reflaction();
		String className="com.techlab.file.operation.example.FileOperation";

		System.out.println("total public method: "+reflact.getCountMethod(className));
		System.out.println("total public field: "+reflact.getCountField(className));
		System.out.println("total public constructor: "+reflact.getCountConstructor(className));
		
	}
}
