package com.techlab.welcome.jframe.test;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;

import com.techlab.button.color.listener.SetBackGroundColorListener;
import com.techlab.button.listener.ButtonFirstListener;
import com.techlab.button.listener.ButtonSecondListener;
import com.techlab.welcome.jframe.WelcomeJFrame;

public class WelcomeJFrameTest {
	public static void main(String args[]) {
		// ButtonFirstListener buttonFirstListener = new ButtonFirstListener();
		// ButtonSecondListener buttonSecondListener = new ButtonSecondListener();
		// WelcomeJFrame welcomeJFrame = new WelcomeJFrame("One Publisher Two
		// observer");
		//
		// JButton helloButton = new JButton("Hello");
		// helloButton.setBounds(50, 50, 150, 70);
		// helloButton.addActionListener(buttonFirstListener);
		// helloButton.addActionListener(buttonSecondListener);
		// welcomeJFrame.add(helloButton);

		WelcomeJFrame welcomeJFrame2 = new WelcomeJFrame("Two Publisher One observer");
		SetBackGroundColorListener setBackGroundColorListener = new SetBackGroundColorListener(welcomeJFrame2);
		welcomeJFrame2.setLocation(550, 0);
		JButton redButton = new JButton("Red");
		redButton.setName("Red");
		redButton.setBounds(50, 50, 150, 70);
		redButton.addActionListener(setBackGroundColorListener);
		welcomeJFrame2.add(redButton);

		JButton blueButton = new JButton("Blue");
		blueButton.setName("Blue");
		blueButton.setBounds(250, 50, 150, 70);
		blueButton.addActionListener(setBackGroundColorListener);
		welcomeJFrame2.add(blueButton);
	}
}
