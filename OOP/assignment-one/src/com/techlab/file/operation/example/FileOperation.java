package com.techlab.file.operation.example;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileOperation {

	public void createFile(File file) {
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void writeFile(File file, String text) {
		try {
			FileWriter writer = new FileWriter(file);
			writer.write(text);
			writer.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void readFile(File file) {
		try {
			FileReader reader=new FileReader(file);
			int text;
			
			while ((text=reader.read()) != -1) {
				System.out.print((char)text);
			}
			reader.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void appendFile(File file, String text) {
		try {
			FileWriter writer = new FileWriter(file,true);
			writer.write(text);
			writer.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
