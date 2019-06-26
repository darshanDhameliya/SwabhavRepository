package com.techlab.linkedhashmap.curd.operation.test;

import com.techlab.linkedhashmap.curd.operation.LinkedHashMapCurdOperation;

public class LinkedHashMapCurdOperationTest {
	public static void main(String args[])
	{
		LinkedHashMapCurdOperation linkedHashMapCurdOperation=new LinkedHashMapCurdOperation();

		linkedHashMapCurdOperation.addName("darshan","dhameliya");
		linkedHashMapCurdOperation.addName("vivek","jivani");
		linkedHashMapCurdOperation.addName("dhanraj","vansadiya");
		linkedHashMapCurdOperation.addName("mitul","kukadiya");
		linkedHashMapCurdOperation.updateName("mitul", "kakadiya");
		
		
		System.out.println(linkedHashMapCurdOperation.getNameList());
	}
}
