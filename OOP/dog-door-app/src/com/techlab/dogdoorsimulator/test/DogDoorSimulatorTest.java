package com.techlab.dogdoorsimulator.test;

import com.techlab.dogdoor.DogDoor;
import com.techlab.remote.Remote;

public class DogDoorSimulatorTest {

		public static void main(String args[])
		{
			DogDoor door=new DogDoor();
			Remote remote=new Remote(door);
			System.out.println("fido barks to go outside...");
			remote.pressButton();
			System.out.println("\nfido has gone outside...");
//			remote.pressButton();
			System.out.println("\nfido`s all done...");
//			remote.pressButton();
			System.out.println("\nfido barks to go inside...");
//			remote.pressButton();
		}
}
