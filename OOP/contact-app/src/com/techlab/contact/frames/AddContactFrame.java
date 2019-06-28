package com.techlab.contact.frames;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.techlab.contact.listener.AddContactListener;

public class AddContactFrame extends JFrame {
	private Font font = new Font("Arial", Font.PLAIN, 20);
	private JLabel contactEmailLabel;
	private JLabel contactNameLabel;
	private JLabel contactMobileNoLabel;
	private JTextField contactNameText;
	private JTextField contactEmailText;
	private JTextField contatcMobileNoText;
	private AddContactListener addContainerListener;

	public AddContactFrame() {
		this.setSize(500, 250);
		this.getContentPane().setBackground(new Color(240, 255, 240));
		this.setTitle("Add Contact");
		this.setLayout(null);
		addContainerListener=new AddContactListener(this);

		contactNameLabel = new JLabel("Name : ");
		contactNameLabel.setBounds(40, 10, 200, 40);
		contactNameLabel.setFont(font);
		contactEmailLabel = new JLabel("Email : ");
		contactEmailLabel.setBounds(40, 50, 220, 40);
		contactEmailLabel.setFont(font);
		contactMobileNoLabel = new JLabel("Mobile No : ");
		contactMobileNoLabel.setBounds(40, 90, 220, 40);
		contactMobileNoLabel.setFont(font);

		this.add(contactNameLabel);
		this.add(contactEmailLabel);
		this.add(contactMobileNoLabel);

		contactNameText = new JTextField();
		contactNameText.setName("contactName");
		contactNameText.setFont(font);
		contactNameText.setBounds(150, 10, 170, 30);
		contactEmailText = new JTextField();
		contactEmailText.setName("contactEmail");
		contactEmailText.setFont(font);
		contactEmailText.setBounds(150, 50, 300, 30);
		contatcMobileNoText = new JTextField();
		contatcMobileNoText.setName("ContactMobileNo");
		contatcMobileNoText.setFont(font);
		contatcMobileNoText.setBounds(150, 90, 200, 30);
		this.add(contactNameText);
		this.add(contactEmailText);
		this.add(contatcMobileNoText);

		JButton addContactButton = new JButton("Add Contact");
		addContactButton.setFont(font);
		addContactButton.setBounds(100, 130, 170, 50);
		addContactButton.addActionListener(addContainerListener);
		this.add(addContactButton);

		this.setVisible(false);
	}

	public String getContactName() {
		return contactNameText.getText();
	}

	public String getContactEmail() {
		return contactEmailText.getText();
	}

	public Long getContactMobileNo() {
		return Long.parseLong(contatcMobileNoText.getText());
	}
}
