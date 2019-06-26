package com.techlab.treemap.curd.operation;

import java.util.HashMap;

public class TreeMapCurdOperation {
	HashMap<String, String> nameList=new HashMap<>();
	
	public void addName(String key,String name)
	{
		nameList.put(key, name);
	}
	public void deleteName(String key)
	{
		nameList.remove(key);
	}
	public void updateName(String key,String newName)
	{
		
		nameList.replace(key, newName);
	}
	public HashMap<String,String> getNameList()
	{
		return nameList;
	}
}
