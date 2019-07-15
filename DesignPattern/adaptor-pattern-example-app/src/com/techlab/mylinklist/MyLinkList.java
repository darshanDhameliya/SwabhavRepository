package com.techlab.mylinklist;

import java.util.Iterator;
import java.util.LinkedList;

public class MyLinkList<T> {
	private LinkedList<T> linkedList;

	public MyLinkList() {
		linkedList = new LinkedList<T>();
	}

	public void addFirst(T item) {
		linkedList.addFirst(item);
	}
	public void addLast(T item) {
		linkedList.addLast(item);
	}

	public T removeFirst() {
		return linkedList.removeFirst();
	}
	public T removeLast() {
		return linkedList.removeLast();
	}
	public int size() {
		return linkedList.size();
	}
	public Iterator<T> iterator() {
		return linkedList.iterator();
	}
}
