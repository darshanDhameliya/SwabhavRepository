package com.techlab.remote;

import java.util.Timer;
import java.util.TimerTask;

import com.techlab.dogdoor.DogDoor;

public class Remote {

	private DogDoor door;

	public Remote(DogDoor door) {
		this.door = door;
	}

	public void pressButton() {
		System.out.println("pressing the remote control button...");
		if (door.isOpen()) {
			door.close();
		} else {
			door.open();

		}
	}
}
