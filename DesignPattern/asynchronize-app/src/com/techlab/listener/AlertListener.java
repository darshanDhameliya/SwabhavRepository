package com.techlab.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlertListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("alert");
	}

}
