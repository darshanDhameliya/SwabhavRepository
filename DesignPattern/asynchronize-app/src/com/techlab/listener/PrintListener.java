package com.techlab.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import com.techlab.newthread.NewThread;


public class PrintListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Thread t1 = new Thread(new NewThread());
		t1.start();
	}

}
