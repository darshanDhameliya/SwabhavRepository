package com.techlab.moveable.test;


import com.techlab.moveable.Car;
import com.techlab.moveable.Moveable;
import com.techlab.moveable.Truck;

public class MoveableTest {
	public static void main(String args[])
	{
		Moveable[] moveables=new Moveable[3];
		moveables[0]=new Truck();
		moveables[1]=new Car();
		moveables[2]=new Truck();
		
		startRace(moveables);
	}
	private static void startRace(Moveable[] moveables)
	{
		for (Moveable moveable : moveables) {
			moveable.move();
		}
	}
}
