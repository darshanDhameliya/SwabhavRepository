package com.techlab.constructor.case2;

public class ChildTest {
	public static void main(String args[])
	{
		Child c1=new Child();
		System.out.println(c1.getFoo());
		Child c2=new Child(100);
		System.out.println(c2.getFoo());
	}

}
