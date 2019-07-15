package com.techlab.contact.field.validation;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class contactFieldValidation {
	public boolean checkNameValidation(String name) {
		if (name.equals(null)) {
			return false;
		}
		return true;
	}

	public boolean checkEmailIdValidation(String emailId, JFrame frame) {
		if (emailId.equals(null)) {
			displayDialog("Please, Enter Email Id", frame);
			return false;
		}
		return true;
	}

	public void displayDialog(String message, JFrame frame) {
		JOptionPane.showMessageDialog(frame, message, "Warning", JOptionPane.PLAIN_MESSAGE);
	}
}
