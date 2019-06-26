package com.techlab.dip.solution;

public class DbLogger implements ILoggable {

	@Override
	public void log(String message) {
		System.out.println(message+" database");

	}
}
