package com.techlab.dogdoor;

import java.util.ArrayList;

import com.techlab.bark.Bark;

public class DogDoor {
	private boolean open;
	private ArrayList<Bark> allowedBark=new ArrayList<Bark>();;

	public DogDoor() {
		this.open = false;
	}

	public void addAllowedBark(Bark bark)
	{
		allowedBark.add(bark);
	}
	public ArrayList<Bark> getAllowedBarks()
	{
		return allowedBark;
	}
	public void open() {
		System.out.println("the dog door is opens.");
		open = true;
	}

	public void close() {
		System.out.println("the dog door is closes.");
		open = false;
	}

	public boolean isOpen() {
		return open;
	}
}
