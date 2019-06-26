package com.techlab.contact.services;

import java.util.ArrayList;

import com.techlab.contact.Contact;
import com.techlab.contact.serialization.ContactSerialization;

public class ContactServices {
	private ArrayList<Contact> arrayContact=new ArrayList<Contact>();
	Contact contact;
	
	public void addContact(String name,String email,Long phoneNo) throws Exception
	{
		contact=new Contact();
		contact.setName(name);
		contact.setEmail(email);
		contact.setPhoneNo(phoneNo);
		
		arrayContact.add(contact);
		

		
	}
	public boolean deleteContact(String name)
	{
		for (Contact contact : arrayContact) {
			if(contact.getName().equals(name))
			{
				arrayContact.remove(contact);
				return true;
			}
		}
		return false;
	}
	
	public void displayContact() {
		for (Contact contact : arrayContact) {
			System.out.println(contact.getName());
			System.out.println(contact.getEmail());
			System.out.println(contact.getPhoneNo()+"\n");
		}
	}

}
