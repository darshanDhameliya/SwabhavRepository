package com.techlab.contact.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.techlab.contact.frames.AddContactFrame;
import com.techlab.contact.services.ContactServices;

public class AddContactListener implements ActionListener {
	private AddContactFrame addContactFrame;
	private ContactServices contactServices = new ContactServices();
	private String name;
	private String email;
	private Long mobileNo;

	public AddContactListener(AddContactFrame addContactFrame) {
		this.addContactFrame = addContactFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		name = addContactFrame.getContactName();
		email = addContactFrame.getContactEmail();
		mobileNo = addContactFrame.getContactMobileNo();

		try {
			contactServices.addContact(name, email, mobileNo);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		addContactFrame.setVisible(false);
	}

}
