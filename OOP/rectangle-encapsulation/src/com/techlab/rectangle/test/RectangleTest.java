package com.techlab.rectangle.test;
import com.techlab.rectangle.Rectangle;

public class RectangleTest {

	public static void main(String args[])
	{
		Rectangle smallRectangle=new Rectangle();
		Rectangle bigRectangle=new Rectangle();

		smallRectangle.setHeigth(10);
		smallRectangle.setWidth(30);
		smallRectangle.setColor("blue");
		bigRectangle.setHeigth(80);
		bigRectangle.setWidth(50);
		bigRectangle.setColor("red");

		System.out.println("small rectangle width:"+smallRectangle.getWidth()+"  heigth:"+smallRectangle.getHeigth()+"  color:"+smallRectangle.getColor());
		System.out.println("small rectangle area:"+smallRectangle.calculateArea());
		System.out.println("big rectangle width:"+bigRectangle.getWidth()+"  heigth:"+bigRectangle.getHeigth()+"  color:"+bigRectangle.getColor());
		System.out.println("big rectangle area:"+bigRectangle.calculateArea());
	}
	
}
