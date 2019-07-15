package com.techlab.iqueue;

public interface IQueue<T> extends Iterable<T>{
	public void enqueue(T item);
	public T dequeue();
	public int count();
}
