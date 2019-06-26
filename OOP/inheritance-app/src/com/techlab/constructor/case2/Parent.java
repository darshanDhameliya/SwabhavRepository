package com.techlab.constructor.case2;

public class Parent {
	private int foo;
	public Parent(int foo)
	{
		this.foo=foo;
	}
	public Parent()
	{
		System.out.println("parent create");
	}
	public int getFoo() {
		return foo;
	}
	
}
