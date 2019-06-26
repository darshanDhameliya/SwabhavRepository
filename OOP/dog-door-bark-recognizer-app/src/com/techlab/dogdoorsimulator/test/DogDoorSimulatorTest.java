package com.techlab.dogdoorsimulator.test;

import com.techlab.barkrecognizer.BarkRecognizer;
import com.techlab.dogdoor.DogDoor;
import com.techlab.remote.Remote;

public class DogDoorSimulatorTest {

	public static void main(String args[]) {
		DogDoor door = new DogDoor();
		BarkRecognizer recognizer = new BarkRecognizer(door);
		Remote remote = new Remote(door);

		System.out.println("fido start barking...");
		recognizer.recognize("woof");
		System.out.println("\nfido has gone outside...");
		System.out.println("\nfido`s all done...");

		try {
			Thread.currentThread().sleep(10000);
			door.close();
		} catch (InterruptedException e) {
		}
		System.out.println("...but he`s stuck outside!");

		System.out.println("fido start barking...");
		recognizer.recognize("woof");
		System.out.println("\nfido back inside...");
		try {
			Thread.currentThread().sleep(10000);
			door.close();
		} catch (InterruptedException e) {
		}
	}
}
