package com.techlab.hashset.curd.operation;

import java.util.HashSet;

public class HashSetCurdOperation {
	HashSet<String> nameList=new HashSet<String>();
	
	public void addName(String name)
	{
		nameList.add(name);
	}
	public void deleteName(String name)
	{
		nameList.remove(name);
	}
	public void updateName(String oldName,String newName)
	{
		for (String string : nameList) {
			if (string.equals(oldName)) {
				nameList.remove(oldName);
				nameList.add(newName);
			}
		}
		
	}
	public HashSet<String> getNameList()
	{
		return nameList;
	}
}
