package com.techlab.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


public class PrintListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Date date=new Date();
		while(true)
			System.out.println(date);
	}

}
