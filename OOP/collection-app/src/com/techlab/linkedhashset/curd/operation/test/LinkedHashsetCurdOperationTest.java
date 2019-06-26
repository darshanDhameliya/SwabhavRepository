package com.techlab.linkedhashset.curd.operation.test;

import com.techlab.linkedhashset.curd.operation.LinkedHashSetCurdOperation;

public class LinkedHashsetCurdOperationTest {
	public static void main(String args[]) {
		LinkedHashSetCurdOperation linkedHashSetCurdOperation = new LinkedHashSetCurdOperation();

		linkedHashSetCurdOperation.addName("darshan");
		linkedHashSetCurdOperation.addName("vivek");
		linkedHashSetCurdOperation.addName("dhanraj");
		linkedHashSetCurdOperation.addName("mitul");
		linkedHashSetCurdOperation.updateName("mitul", "hiren");

		for (String string : linkedHashSetCurdOperation.getNameList()) {
			System.out.println(string);

		}
	}
}
