package com.techlab.dogdoorsimulator.test;

import com.techlab.bark.Bark;
import com.techlab.barkrecognizer.BarkRecognizer;
import com.techlab.dogdoor.DogDoor;
import com.techlab.remote.Remote;

public class DogDoorSimulatorTest {

	public static void main(String args[]) {
		DogDoor door = new DogDoor();
		door.addAllowedBark(new Bark("rowlf"));
		door.addAllowedBark(new Bark("rooowlf"));
		door.addAllowedBark(new Bark("rawlf"));
		door.addAllowedBark(new Bark("woof"));
		
		BarkRecognizer recognizer = new BarkRecognizer(door);
		Remote remote = new Remote(door);

		System.out.println("Bruce start barking...");
		recognizer.recognize(new Bark("rowlf"));
		
		System.out.println("\nBruce has gone outside...");

		try {
			Thread.currentThread().sleep(10000);
			door.close();
		} catch (InterruptedException e) {
		}

		System.out.println("\nBruce`s all done...");
		System.out.println("...but he`s stuck outside!");

		Bark smallDogBark=new Bark("yip");
		System.out.println("A small dog starts barking...");
		recognizer.recognize(new Bark("yip"));
		
		
		
		System.out.println("Bruce start barking...");
		recognizer.recognize(new Bark("rooowlf"));
		
		System.out.println("\nBruce`s back inside...");
		try {
			Thread.currentThread().sleep(5000);
			door.close();
		} catch (InterruptedException e) {
		}
	}
}
