package com.techlab.treemap.curd.operation.test;

import com.techlab.treemap.curd.operation.TreeMapCurdOperation;

public class TreeMapCurdOperationTest {
	public static void main(String args[])
	{
		TreeMapCurdOperation treeMapCurdOperation=new TreeMapCurdOperation();

		treeMapCurdOperation.addName("darshan","dhameliya");
		treeMapCurdOperation.addName("vivek","jivani");
		treeMapCurdOperation.addName("dhanraj","vansadiya");
		treeMapCurdOperation.addName("mitul","kukadiya");
		treeMapCurdOperation.updateName("mitul", "kakadiya");
		
		
		System.out.println(treeMapCurdOperation.getNameList());
	}
}
