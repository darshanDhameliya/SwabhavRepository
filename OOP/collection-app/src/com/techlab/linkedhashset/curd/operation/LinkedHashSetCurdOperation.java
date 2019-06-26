package com.techlab.linkedhashset.curd.operation;

import java.util.LinkedHashSet;

public class LinkedHashSetCurdOperation {
	LinkedHashSet<String> nameList = new LinkedHashSet<String>();

	public void addName(String name) {
		nameList.add(name);
	}

	public void deleteName(String name) {
		nameList.remove(name);
	}

	public void updateName(String oldName, String newName) {
		for (String string : nameList) {
			if (string.equals(oldName)) {
				nameList.remove(oldName);
				nameList.add(newName);
			}
		}

	}

	public LinkedHashSet<String> getNameList() {
		return nameList;
	}
}
