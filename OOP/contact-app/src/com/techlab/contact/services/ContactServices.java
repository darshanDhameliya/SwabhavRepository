package com.techlab.contact.services;

import java.util.ArrayList;

import com.techlab.contact.Contact;
import com.techlab.contact.serialization.ContactSerialization;

public class ContactServices {
	private ArrayList<Contact> arrayContact = new ArrayList<Contact>();
	
	public void addContact(String name, String email, Long phoneNo) throws Exception {
		arrayContact=ContactSerialization.deSerialization();
		
		Contact contact = new Contact();
		contact.setName(name);
		contact.setEmail(email);
		contact.setPhoneNo(phoneNo);
		arrayContact.add(contact);

		 ContactSerialization.serialization(arrayContact);
	}

	public void deleteContact(String name) throws Exception {
		 arrayContact=null;
		 arrayContact = ContactSerialization.deSerialization();
		for (Contact contact : arrayContact) {
			if (contact.getName().equals(name)) {
				arrayContact.remove(contact);
			}
		}
		ContactSerialization.serialization(arrayContact);
	}

	public void displayContact() throws Exception {
		 arrayContact=null;
		 arrayContact = ContactSerialization.deSerialization();
		for (Contact contact : arrayContact) {
			System.out.println(contact.getName());
			System.out.println(contact.getEmail());
			System.out.println(contact.getPhoneNo() + "\n");
		}
	}
	public ArrayList<Contact> getContactList() throws Exception {
		 return ContactSerialization.deSerialization();
		
	}

}
