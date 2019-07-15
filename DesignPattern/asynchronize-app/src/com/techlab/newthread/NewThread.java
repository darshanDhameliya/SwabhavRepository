package com.techlab.newthread;

import java.util.Date;

public class NewThread implements Runnable{

	@Override
	public void run() {
		Date date=new Date();
		while(true)
			System.out.println(date);
	}

}
