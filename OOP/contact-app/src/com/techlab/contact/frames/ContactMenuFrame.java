package com.techlab.contact.frames;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.techlab.contact.listener.ContactMenuListener;

public class ContactMenuFrame extends JFrame {

	private ContactMenuListener contactMenuListener = new ContactMenuListener();
	private Font font = new Font("Arial", Font.PLAIN, 20);

	public ContactMenuFrame() {
		this.setSize(800, 800);
		this.getContentPane().setBackground(new Color(240, 255, 240));
		this.setTitle("Contact Menu");
		this.setLayout(null);

		JButton addContactButton = new JButton("Add Contact");
		addContactButton.setName("addContact");
		addContactButton.setFont(font);
		addContactButton.setBounds(50, 20, 170, 50);
		addContactButton.addActionListener(contactMenuListener);
		this.add(addContactButton);

		JButton deleteContactButton = new JButton("Delete Contact");
		deleteContactButton.setName("deleteContact");
		deleteContactButton.setFont(font);
		deleteContactButton.setBounds(270, 20, 170, 50);
		deleteContactButton.addActionListener(contactMenuListener);
		this.add(deleteContactButton);

		JButton displayContactButton = new JButton("Display Contact");
		displayContactButton.setName("displayContact");
		displayContactButton.setFont(font);
		displayContactButton.setBounds(150, 90, 190, 50);
		displayContactButton.addActionListener(contactMenuListener);
		this.add(displayContactButton);
		this.setVisible(true);
	}

}
