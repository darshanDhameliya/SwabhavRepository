package com.techlab.contact.consoul;

import com.techlab.contact.services.ContactServices;

public class ContactConsole {
	private ContactServices contact=new ContactServices();

	public void startConsole() throws Exception
	{

		contact.addContact("darshan","darshan18@gmail.com",9099691799l);
		contact.addContact("vivek","vivek18@gmail.com",8099691790l);
		contact.addContact("hiren","hiren18@gmail.com",7099691791l);
		
		
		System.out.println("----Contact-List----\n");
	
		contact.displayContact();
		
		System.out.println("contact is delete : "+contact.deleteContact("vivek"));

		System.out.println("----Contact-List----\n");
	
		contact.displayContact();
		
		while(true)
		{}
	}
}
