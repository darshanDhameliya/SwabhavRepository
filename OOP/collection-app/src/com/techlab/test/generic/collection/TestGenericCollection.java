package com.techlab.test.generic.collection;

import java.util.ArrayList;
import java.util.HashSet;

import com.techlab.line.item.LineItem;

public class TestGenericCollection {

	public static void main(String args[])
	{
		
		HashSet cart=new HashSet();

		cart.add(new LineItem(101, "bat", 600.00, 5));
		cart.add(new LineItem(102, "ball", 100.00, 9));
		cart.add(new LineItem(103, "cap", 150.50, 10));
		cart.add("darshan");
		cart.add(20);
	
//		for (LineItem lineItem : cart) {
//			System.out.println("id :"+lineItem.getId());
//			System.out.println("product name :"+lineItem.getProductName());
//			System.out.println("price :"+lineItem.getPrice());
//			System.out.println("quantity :"+lineItem.getQuantity());
//			System.out.println("calculate item cost :"+lineItem.calculateItemCost());
//		}
		for (Object object : cart) {
			System.out.println(object);
		}
	}
}
