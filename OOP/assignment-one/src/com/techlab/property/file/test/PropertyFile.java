package com.techlab.property.file.test;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyFile {
	private Properties proparties;
	private String path;
	private String fileName;
	private FileOutputStream outputStream;
	private FileInputStream inputStream;

	public void setProparties() {
		fileName = "propertyFile.properties";
		path = "E:\\" + fileName;
		try {
			outputStream = new FileOutputStream(path);
			proparties = new Properties();
			
			proparties.setProperty("name", "Darshan");
			proparties.setProperty("age", "19");
			proparties.store(outputStream, null);

		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	public void getProparties() {

		try {
			inputStream = new FileInputStream(path);
			Properties properties = new Properties();
			
			properties.load(inputStream);
			
			System.out.println(properties.getProperty("name"));
			System.out.println(properties.getProperty("age"));
			
		} catch (FileNotFoundException exception) {
			System.out.println("File not found");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public void updateProparties() {
		try {
			
			Properties properties = new Properties();
			
			outputStream = new FileOutputStream(path);
			properties.setProperty("name", "dr");
			properties.setProperty("age", "21");
			properties.store(outputStream, null);
			outputStream.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		

	}


}
