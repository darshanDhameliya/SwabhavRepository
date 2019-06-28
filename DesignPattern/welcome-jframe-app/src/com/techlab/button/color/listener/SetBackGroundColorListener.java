package com.techlab.button.color.listener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.techlab.welcome.jframe.WelcomeJFrame;

public class SetBackGroundColorListener implements ActionListener {

	WelcomeJFrame frame;
	Color color;

	public SetBackGroundColorListener(WelcomeJFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clickedButton = (JButton) e.getSource();
		String buttonName = clickedButton.getName();
		if (buttonName.equals("Red")) {
			frame.getContentPane().setBackground(Color.red);
		}
		if (buttonName.equals("Blue")) {
			frame.getContentPane().setBackground(Color.blue);
		}
	}

}
