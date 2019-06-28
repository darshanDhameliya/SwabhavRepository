package com.techlab.contact.consoul;

import java.util.Scanner;

import com.techlab.contact.services.ContactServices;

public class ContactConsole {
	private ContactServices contact = new ContactServices();
	private Scanner inputValue = new Scanner(System.in);
	private String userChoice;
	private boolean isValidState = true;
	private String contactName;
	private String contactEmailId;
	private long contactMobileNo;

	public void startConsole() throws Exception {

	

		while (isValidState) {

			System.out.println("1. Add Contact");
			System.out.println("2. Delete Contact");
			System.out.println("3. Display Contact");
			System.out.println("4. Exit");

			System.out.print("Enter Choice : ");
			userChoice = inputValue.nextLine();

			switch (userChoice) {
			case "1":
				addContact();
				break;
			case "2":
				deleteContact();
				break;
			case "3":
				displayContact();
				break;
			case "4":
				isValidState = false;
				break;

			default:
				System.out.println("please, Enter proper choice");
				break;
			}
		}
		
	}

	private void addContact() throws Exception {
		System.out.println("Enter contact name : ");
		contactName = inputValue.nextLine();
		System.out.println("Enter contact Email Id : ");
		contactEmailId = inputValue.nextLine();
		System.out.println("Enter contact Mobile No : ");
		contactMobileNo = Long.parseLong(inputValue.nextLine());
		
		contact.addContact(contactName, contactEmailId, contactMobileNo);

	}

	private void deleteContact() throws Exception {

		System.out.println("Enter contact name : ");
		contactName = inputValue.nextLine();
		
		contact.deleteContact(contactName);
	}

	private void displayContact() throws Exception {

		System.out.println("\n----Contact-List----\n");

		contact.displayContact();
	}
}
