package com.techlab.autoboxing.example;

public class AutoBoxing {
	public static void Boxing(Integer i,int j)
	{
		i=j;
		System.out.println("boxing i:"+i+"  j:"+j);
	}
	public static void UnBoxing(Integer i,int j)
	{
		j=i;
		System.out.println("unboxing i:"+i+"  j:"+j);
	}
	
}
