package com.techlab.contact.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.techlab.contact.Contact;


public class ContactSerialization {
	private static Contact contact=new Contact();
	
	public static void serialization(Contact contact) throws Exception {

		FileOutputStream fout = new FileOutputStream("res\\contactList.txt");
		ObjectOutputStream out = new ObjectOutputStream(fout);

		out.writeObject(contact);
		out.flush();
		out.close();

		System.out.println("serialization success");

	}
	public static void deSerialization() throws Exception {
		contact=null;

		FileInputStream fin = new FileInputStream("res\\contactList.txt");
		ObjectInputStream in=new ObjectInputStream(fin);
		
		contact=(Contact)in.readObject();
		in.close();

		System.out.println("Deserialization success");
	}
}
