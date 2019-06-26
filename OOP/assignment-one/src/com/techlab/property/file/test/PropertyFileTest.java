package com.techlab.property.file.test;

public class PropertyFileTest {
	public static void main(String args[])
	{
		PropertyFile propertyFile =new PropertyFile();
		
		propertyFile.setProparties();
		propertyFile.getProparties();
		propertyFile.updateProparties();
		propertyFile.getProparties();
	}
}
