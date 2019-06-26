package com.techlab.elder.human.test;

import com.techlab.human.GenderType;
import com.techlab.human.Human;

public class ElderHumanTest {
	public static void main(String args[]) {
		Human darshan = new Human("darshan", 23, 4.9f, 40f, GenderType.MALE);
		Human vivek = new Human("vivek", 21, 4.9f, 40f, GenderType.MALE);
		Human elder=darshan.whoIsElder(vivek);

		System.out.println("elder human name: "+elder.getHumanName());
		System.out.println("darshan hasecode: "+darshan.hashCode());
		System.out.println("vivek hasecode: "+vivek.hashCode());
		System.out.println("elder hashcode: "+elder.hashCode());
	}

}
