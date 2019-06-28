package com.techlab.welcome.jframe;

import java.awt.Color;

import javax.swing.JFrame;

public class WelcomeJFrame extends JFrame {

	public WelcomeJFrame(String title) {
		this.setSize(500,500);
		this.getContentPane().setBackground(Color.lightGray);
		this.setTitle(title);
		this.setLayout(null);
		this.setVisible(true);
	}
}
