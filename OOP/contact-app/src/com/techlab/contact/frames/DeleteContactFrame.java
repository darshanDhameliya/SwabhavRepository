package com.techlab.contact.frames;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.techlab.contact.listener.DeleteContactListener;

public class DeleteContactFrame extends JFrame {
	private Font font = new Font("Arial", Font.PLAIN, 20);
	private JLabel contactNameLabel;
	private JTextField contactNameText;
	private DeleteContactListener deleteContactListener;

	public DeleteContactFrame() {
		deleteContactListener = new DeleteContactListener(this);
		this.setSize(400, 170);
		this.getContentPane().setBackground(new Color(240, 255, 240));
		this.setTitle("Delete Contact");
		this.setLayout(null);

		contactNameLabel = new JLabel("Name : ");
		contactNameLabel.setBounds(40, 10, 200, 40);
		contactNameLabel.setFont(font);

		this.add(contactNameLabel);

		contactNameText = new JTextField();
		contactNameText.setName("contactName");
		contactNameText.setFont(font);
		contactNameText.setBounds(150, 10, 170, 30);
		this.add(contactNameText);

		JButton deleteContactButton = new JButton("Delete Contact");
		deleteContactButton.setFont(font);
		deleteContactButton.setBounds(100, 50, 170, 50);
		deleteContactButton.addActionListener(deleteContactListener);
		this.add(deleteContactButton);

		this.setVisible(false);
	}

	public String getContactName() {
		return contactNameText.getText();
	}
}
