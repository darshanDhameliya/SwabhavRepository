package com.techlab.test.collection;

import java.util.ArrayList;

import com.techlab.line.item.LineItem;

public class TestCollection {

	public static void main(String args[])
	{
		ArrayList cart=new ArrayList();

		cart.add(new LineItem(101, "bat", 600.00, 5));
		cart.add(new LineItem(102, "ball", 100.00, 9));
		cart.add(new LineItem(103, "cap", 150.50, 10));
		cart.add("darshan");
		cart.add(20);
		
		for (Object object : cart) {
			LineItem lineItem=(LineItem) object;
			System.out.println(lineItem.calculateItemCost());
		}
	}
}
