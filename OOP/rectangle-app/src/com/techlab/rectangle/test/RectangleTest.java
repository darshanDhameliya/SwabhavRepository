package com.techlab.rectangle.test;
import com.techlab.rectangle.Rectangle;

public class RectangleTest {

	public static void main(String args[])
	{
		Rectangle small=new Rectangle();
		Rectangle big=new Rectangle();

		small.heigth=10;
		small.width=30;
		
		big.heigth=80;
		big.width=50;

		System.out.println("small rectangle width:"+small.width+"  heigth:"+small.heigth);
		System.out.println("small rectangle area:"+small.calculateArea());
		System.out.println("big rectangle width:"+big.width+"  heigth:"+big.heigth);
		System.out.println("big rectangle area:"+big.calculateArea());
	}
}
