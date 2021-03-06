package com.techlab.data.loaded;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;

public class URLLoaded implements DataLoaded {
	private HashSet<String> strings = new HashSet<String>();
	private String line;

	@Override
	public HashSet<String> dataLoaded(String path) {

		BufferedReader reader = null;
		URL url = null;
		
		try {
			url = new URL(path);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}

		try {
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((line = reader.readLine()) != null) {
				strings.add(line);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return strings;
	}

}
