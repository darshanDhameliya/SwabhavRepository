package com.techlab.queue.test;

import com.techlab.iqueue.IQueue;
import com.techlab.queue.adaptor.QueueAdaptor;

public class QueueTest {
	public static void main(String args[]) {
		IQueue<String> stringQ = new QueueAdaptor<String>();

		stringQ.enqueue("darshan");
		stringQ.enqueue("dhanraj");
		stringQ.enqueue("vivek");
		stringQ.enqueue("hiren");

		System.out.println(stringQ.dequeue());
		System.out.println(stringQ.count());
		
		for (String e : stringQ) {
			System.out.println(e);
		}
	}
}
