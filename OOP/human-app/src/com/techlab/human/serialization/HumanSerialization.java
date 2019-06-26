package com.techlab.human.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.techlab.human.*;

public class HumanSerialization {
	Human human = new Human("dhanraj", 19);
	String path;
	String fileName;

	public void setPath(String path) {
		this.path = path;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void serialization(Human human) throws Exception {

		FileOutputStream fout = new FileOutputStream(path + fileName);
		ObjectOutputStream out = new ObjectOutputStream(fout);

		out.writeObject(human);
		out.flush();
		out.close();

		System.out.println("serialization success");

	}
	public void deSerialization() throws Exception {
		human=null;

		FileInputStream fin = new FileInputStream(path + fileName);
		ObjectInputStream in=new ObjectInputStream(fin);
		
		human=(Human)in.readObject();
		in.close();

		System.out.println("Deserialization success");
		System.out.println("Name : "+human.getHumanName());
	}
}
