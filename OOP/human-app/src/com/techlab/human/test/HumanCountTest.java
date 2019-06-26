package com.techlab.human.test;

import com.techlab.human.GenderType;
import com.techlab.human.Human;

public class HumanCountTest {

	public static void main(String args[]) {
		Human human1 = new Human("darshan", 19, 4.9f, 40f, GenderType.MALE);
		System.out.println("count : " + Human.headCount());
		Human human2 = new Human("vivek", 19, 4.9f, 40f, GenderType.MALE);
		System.out.println("count : " + Human.headCount());
		Human human3 = new Human("hiren", 19, 4.9f, 40f, GenderType.MALE);
		System.out.println("count : " + Human.headCount());
	}
}
