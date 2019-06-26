package com.techlab.human.test;
import com.techlab.human.*;

public class HumanTest {
	public static void main(String args[])
	{
		Human human1=new Human("darshan",19,4.9f,40f,GenderType.MALE);
		

		System.out.println("human name="+human1.getHumanName());
		System.out.println("human age="+human1.getHumanAge());
		System.out.println("human height="+human1.getHumanHeight());
		System.out.println("human weight="+human1.getHumanWeight());
		System.out.println("human gender="+human1.getHumanGender());

		human1.humanWorkout();
		human1.humanEat();
		

		System.out.println("human height="+human1.getHumanHeight());
		System.out.println("human weight="+human1.getHumanWeight());

		System.out.println("human BMI="+human1.calculateBMI());
		System.out.println("human body category="+human1.getBodyCategories());
		
	}

}
