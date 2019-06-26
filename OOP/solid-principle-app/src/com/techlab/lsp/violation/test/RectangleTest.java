package com.techlab.lsp.violation.test;

import com.techlab.lsp.violation.Rectangle;
import com.techlab.lsp.violation.Square;

public class RectangleTest {

	public static void main(String args[])
	{
		shouldNotChangeHightIfWidthIsChange(new Rectangle(50, 100));
		shouldNotChangeHightIfWidthIsChange(new Square(50));
		
	}
	public static void shouldNotChangeHightIfWidthIsChange(Rectangle r)
	{
		int beforeHight=r.getHight();
		r.setWidth(r.getWidth()+5);
		int afterHight=r.getHight();

		System.out.println("before hight : "+beforeHight);
		System.out.println("after hight : "+afterHight);
		System.out.println(beforeHight==afterHight);
		System.out.println(r.calculateArea());
	}
	public static void shouldNotChangeHightIfWidthIsChange(Square s)
	{
		int beforeHight=s.getSide();
		s.setSide(s.getSide()+5);
		int afterHight=s.getSide();

		System.out.println("before hight : "+beforeHight);
		System.out.println("after hight : "+afterHight);
		System.out.println(beforeHight==afterHight);
		System.out.println(s.calculateArea());
	}
}
