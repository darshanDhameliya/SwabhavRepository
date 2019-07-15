package com.techlab.store.file;

import java.io.FileWriter;

public class StoreHtmlFileOnDisk implements IStoreFile {
	@Override
	public void storeFile(String file, String htmlString) {

		try {
			FileWriter writer = new FileWriter(file);
			writer.write(htmlString);
			writer.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
