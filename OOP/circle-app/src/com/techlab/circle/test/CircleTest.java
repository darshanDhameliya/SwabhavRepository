package com.techlab.circle.test;

import com.techlab.circle.BorderColor;
import com.techlab.circle.Circle;

public class CircleTest {
	public static void main(String args[]) {
		Circle[] circleArray = new Circle[5];

		for (int i = 0; i < 5; i++) {
			circleArray[i] = new Circle();
		}

		circleArray[0].setRediusCircle(10.05f);
		circleArray[0].setBorderColorCircle(BorderColor.red);

		circleArray[1].setRediusCircle(4.05f);
		circleArray[1].setBorderColorCircle(BorderColor.blue);

		circleArray[2].setRediusCircle(6.10f);
		circleArray[2].setBorderColorCircle(BorderColor.green);

		circleArray[3].setRediusCircle(4.02f);
		circleArray[3].setBorderColorCircle(BorderColor.red);

		circleArray[4].setRediusCircle(5.01f);
		circleArray[4].setBorderColorCircle(BorderColor.blue);
		
		displayArea(circleArray);
		displaySumOfCircleArea(circleArray);

	}

	private static void displayArea(Circle[] circleArray) {
		for (Circle circle : circleArray) {
			System.out.println(" circle redius:" + circle.getRediusCircle() + "     border color:"
					+ circle.getBorderColorCircle());
			System.out.println("  area:" + circle.calculateCircleArea());

		}
	}
	private static void displaySumOfCircleArea(Circle[] circleArray)
	{
		float sumOfCirclesArea = 0f;
		
		for (Circle circle : circleArray) {
			sumOfCirclesArea = sumOfCirclesArea + circle.calculateCircleArea();
		}
		System.out.println("sum of circles area:" + sumOfCirclesArea);
	}

}
