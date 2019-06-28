package com.techlab.contact.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.techlab.contact.Contact;

public class ContactSerialization {

	public static void serialization(ArrayList<Contact> arrayContact) throws Exception {

		FileOutputStream fout = new FileOutputStream("res\\contactList.dat");
		ObjectOutputStream out = new ObjectOutputStream(fout);

		out.writeObject(arrayContact);
		out.flush();
		out.close();

	}

	public static ArrayList<Contact> deSerialization() throws Exception {

		FileInputStream fin = new FileInputStream("res\\contactList.dat");
		ObjectInputStream in = new ObjectInputStream(fin);

		ArrayList arrayContact = (ArrayList) in.readObject();
		in.close();

		return arrayContact;
	}
}
