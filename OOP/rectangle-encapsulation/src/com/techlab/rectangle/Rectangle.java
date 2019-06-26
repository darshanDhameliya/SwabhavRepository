package com.techlab.rectangle;

public class Rectangle {
	private int width;
	private int heigth;
	private int MIN_NUMBER=1;
	private int MAX_NUMBER=100;
	private String color;

	public void setHeigth(int heigth) {
		this.heigth = validValue(heigth);
	}

	public void setWidth(int width) {
		this.width = validValue(width);
	}
	
	public void setColor(String color) {
		this.color = checkValidColor(color);
	}

	private int validValue(int value) {
		if (value < MIN_NUMBER)
			value = MIN_NUMBER;
		if (value > MAX_NUMBER)
			value = MAX_NUMBER;
		return value;
	}
	private String checkValidColor(String color) {
		String colorLowerCase;
		
		colorLowerCase=color.toLowerCase();
		
		if(colorLowerCase=="red" || colorLowerCase=="green" || colorLowerCase=="blue")
			return color;
		
		return "red";
	}
	

	public int getHeigth() {
		return heigth;
	}

	public int getWidth() {
		return width;
	}
	public String getColor() {
		return color;
	}

	public int calculateArea() {
		return width * heigth;
	}

}
