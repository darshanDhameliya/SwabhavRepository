package com.techlab.barkrecognizer;

import com.techlab.dogdoor.DogDoor;

public class BarkRecognizer {
	private DogDoor door;
	public BarkRecognizer(DogDoor door)
	{
		this.door=door;
	}
	public void recognize(String bark)
	{
		System.out.println("  BarkRecognizer: Head a `"+bark+"`");
		door.open();
	}
}
