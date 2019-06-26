package com.techlab.reference.test;
import com.techlab.rectangle.Rectangle;

public class ReferenceTest {
	public static void main(String args[])
	{
			Rectangle r1=new Rectangle();
			r1.setHeigth(10);
			r1.setWidth(30);
			printInfo(r1);
			
			Rectangle r2=r1;
			printInfo(r2);
			
			r1.setWidth(100);
			printInfo(r1);
			printInfo(r2);

			System.out.println("rectangle area:"+new Rectangle().calculateArea());
			printInfo(new Rectangle());

	}
	static void printInfo(Rectangle r1)
	{
		System.out.println("rectangle width:"+r1.getWidth());
		System.out.println("rectangle heigth:"+r1.getHeigth());
		System.out.println("rectangle hashCode:"+r1.hashCode());
		
	}
}
