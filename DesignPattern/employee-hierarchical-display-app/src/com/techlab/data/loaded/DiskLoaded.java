package com.techlab.data.loaded;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class DiskLoaded implements DataLoaded {
	private HashSet<String> strings = new HashSet<String>();
	private String line;

	public HashSet<String> dataLoaded(String path) {
		File file = new File(path);

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		try {
			while ((line = br.readLine()) != null) {
				strings.add(line);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return strings;
	}

}
