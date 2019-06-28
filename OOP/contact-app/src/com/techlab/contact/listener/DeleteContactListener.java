package com.techlab.contact.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.techlab.contact.frames.DeleteContactFrame;
import com.techlab.contact.services.ContactServices;

public class DeleteContactListener implements ActionListener {
	private DeleteContactFrame deleteContactFrame;
	private ContactServices contactServices = new ContactServices();
	private String name;

	public DeleteContactListener(DeleteContactFrame deleteContactFrame) {
		this.deleteContactFrame = deleteContactFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		name = deleteContactFrame.getContactName();
		try {
			contactServices.deleteContact(name);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		deleteContactFrame.setVisible(false);
	}
}
