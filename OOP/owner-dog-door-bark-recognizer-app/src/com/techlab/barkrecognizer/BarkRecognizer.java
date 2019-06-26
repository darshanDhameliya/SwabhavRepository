package com.techlab.barkrecognizer;

import java.util.ArrayList;

import com.techlab.bark.Bark;
import com.techlab.dogdoor.DogDoor;

public class BarkRecognizer {
	private DogDoor door;

	public BarkRecognizer(DogDoor door) {
		this.door = door;
	}

	public void recognize(Bark bark) {
		System.out.println("  BarkRecognizer: Head a `" + bark.getSound() + "`");
		ArrayList<Bark> allowedBarks = door.getAllowedBarks();

		for (Bark bark2 : allowedBarks) {
			if (bark2.equals(bark)) {
				door.open();
				return;
			}
		}
		
		System.out.println("this dog bark is not allowed");
	}

}
