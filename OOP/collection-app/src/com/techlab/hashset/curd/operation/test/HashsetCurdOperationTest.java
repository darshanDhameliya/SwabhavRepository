package com.techlab.hashset.curd.operation.test;

import com.techlab.hashset.curd.operation.HashSetCurdOperation;

public class HashsetCurdOperationTest {
	public static void main(String args[])
	{
		HashSetCurdOperation hashSetCurdOperation=new HashSetCurdOperation();

		
		hashSetCurdOperation.addName("darshan");
		hashSetCurdOperation.addName("vivek");
		hashSetCurdOperation.addName("dhanraj");
		hashSetCurdOperation.addName("mitul");
		hashSetCurdOperation.updateName("mitul", "hiren");
		
		
		for (String string : hashSetCurdOperation.getNameList()) {
			System.out.println(string);
			
		}
	}
}
