package com.techlab.hashmap.curd.operation.test;

import com.techlab.hashmap.curd.operation.HashMapCurdOperation;

public class HashMapCurdOperationTest {
	public static void main(String args[])
	{
		HashMapCurdOperation hashMapCurdOperation=new HashMapCurdOperation();

		hashMapCurdOperation.addName("darshan","dhameliya");
		hashMapCurdOperation.addName("vivek","jivani");
		hashMapCurdOperation.addName("dhanraj","vansadiya");
		hashMapCurdOperation.addName("mitul","kukadiya");
		hashMapCurdOperation.updateName("mitul", "kakadiya");
		
		
		System.out.println(hashMapCurdOperation.getNameList());
	}
}
