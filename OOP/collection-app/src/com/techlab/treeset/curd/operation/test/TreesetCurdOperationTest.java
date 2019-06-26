package com.techlab.treeset.curd.operation.test;

import com.techlab.treeset.curd.operation.TreeSetCurdOperation;

public class TreesetCurdOperationTest {
	public static void main(String args[]) {
		TreeSetCurdOperation treeSetCurdOperation = new TreeSetCurdOperation();

		treeSetCurdOperation.addName("darshan");
		treeSetCurdOperation.addName("vivek");
		treeSetCurdOperation.addName("dhanraj");
		treeSetCurdOperation.addName("mitul");
		treeSetCurdOperation.updateName("mitul", "hiren");

		for (String string : treeSetCurdOperation.getNameList()) {
			System.out.println(string);

		}
	}
}
