package com.techlab.lsp.violation;

public class Rectangle {

	protected int hight;
	protected int width;

	public Rectangle(int width, int hight) {
		this.hight = hight;
		this.width = width;
	}

	public int getHight() {
		return hight;
	}

	public int getWidth() {
		return width;
	}

	public void setHight(int hight) {
		this.hight = hight;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public double calculateArea() {
		return hight * width;
	}
}
