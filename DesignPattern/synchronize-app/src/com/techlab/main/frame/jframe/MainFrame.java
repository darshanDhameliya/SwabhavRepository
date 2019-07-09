package com.techlab.main.frame.jframe;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.omg.PortableServer.THREAD_POLICY_ID;

import com.techlab.listener.AlertListener;
import com.techlab.listener.PrintListener;

public class MainFrame extends JFrame {
	public MainFrame() {
		this.setSize(600,300);
		this.getContentPane().setBackground(Color.lightGray);
		this.setTitle("Main Frame");
		this.setLayout(null);
		this.setVisible(true);
		setButtons();
	}
	private void setButtons()
	{
		Font font=new Font("comic sans", Font.PLAIN, 30);
		JButton printButton=new JButton("Print");
		printButton.setFont(font);
		printButton.addActionListener(new PrintListener());
		printButton.setBounds(60,80,200,80);
		this.add(printButton);

		JButton alertButton=new JButton("Alert");
		alertButton.setFont(font);
		alertButton.addActionListener(new AlertListener());
		alertButton.setBounds(280,80,200,80);
		this.add(alertButton);
	}
}
