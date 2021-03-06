package com.techlab.factory.method.part.three;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Proparties {
	private Properties properties;
	private String path;
	private String fileName;
	private FileOutputStream outputStream;
	private FileReader fileReader;

	public String getProparties() throws ClassNotFoundException {
		fileName = "config.properties";
		path = "D:\\eclipse\\eclipse-workspace\\design-patterns-app\\Properties\\" + fileName;
	
		try {
			fileReader = new FileReader(path);
			properties = new Properties();

			properties.load(fileReader);

		} catch (FileNotFoundException exception) {
			System.out.println("File not found");
		} catch (IOException e) {

			e.printStackTrace();
		}
		return properties.getProperty("car");
	}

}
