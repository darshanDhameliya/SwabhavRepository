package com.techlab.queue.adaptor;

import java.util.Iterator;
import java.util.LinkedList;

import com.techlab.iqueue.IQueue;
import com.techlab.mylinklist.MyLinkList;

public class QueueAdaptor<T> implements IQueue<T>{
	private MyLinkList<T> adaptor=new MyLinkList<T>();

	@Override
	public void enqueue(T item) {
		adaptor.addLast(item);
	}

	@Override
	public T dequeue() {
		return adaptor.removeFirst();
	}

	@Override
	public int count() {
		return adaptor.size();
	}

	@Override
	public Iterator<T> iterator() {
		
		return adaptor.iterator();
	}
}
