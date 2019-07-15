package com.techlab.control.test;

import com.techlab.control.Control;
import com.techlab.control.group.ControlGroup;
import com.techlab.store.file.IStoreFile;
import com.techlab.store.file.StoreHtmlFileOnDisk;

public class ControlTest {
	public static void main(String args[]) {
		IStoreFile storeFile = new StoreHtmlFileOnDisk();

		Control inputName = new Control("Enter name", "input", "text");
		Control inputMobileNo = new Control("Mobile no", "input", "text");
		Control firstSimpleText = new Control("ddddddddddd");
		Control secondSimpleText = new Control("rrrrrrrrrrr");

		ControlGroup contactDetailForm = new ControlGroup("div");
		ControlGroup textGroup = new ControlGroup("section");

		contactDetailForm.addChildren(inputName);
		contactDetailForm.addChildren(inputMobileNo);
		contactDetailForm.addChildren(textGroup);
		textGroup.addChildren(firstSimpleText);
		textGroup.addChildren(secondSimpleText);

		storeFile.storeFile("res\\contactForm.html", contactDetailForm.parseToHtml());
	}
}
