package com.techlab.contact.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.techlab.contact.frames.AddContactFrame;
import com.techlab.contact.frames.DeleteContactFrame;
import com.techlab.contact.frames.DisplayContactFrame;

public class ContactMenuListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		switch (button.getName()) {
		case "addContact":
			AddContactFrame addContactFrame = new AddContactFrame();
			addContactFrame.setVisible(true);
			break;
		case "deleteContact":
			DeleteContactFrame deleteContactFrame = new DeleteContactFrame();
			deleteContactFrame.setVisible(true);
			break;
		case "displayContact":
			DisplayContactFrame displayContactFrame = new DisplayContactFrame();
			displayContactFrame.setVisible(true);
			break;

		}
	}

}
