package com.techlab.treeset.curd.operation;

import java.util.TreeSet;

public class TreeSetCurdOperation {
	TreeSet<String> nameList = new TreeSet<String>();

	public void addName(String name) {
		nameList.add(name);
	}

	public void deleteName(String name) {
		nameList.remove(name);
	}

	public void updateName(String oldName, String newName) {

		if (nameList.remove(oldName))
			nameList.add(newName);

	}

	public TreeSet<String> getNameList() {
		return nameList;
	}
}
