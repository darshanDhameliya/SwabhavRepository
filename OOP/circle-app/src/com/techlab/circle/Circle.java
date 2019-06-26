package com.techlab.circle;

public class Circle {
	private float rediusCircle;
	public BorderColor borderColor;
	
	public void setRediusCircle(float rediusCircle)
	{
		this.rediusCircle=rediusCircle;
	}
	public void setBorderColorCircle(BorderColor borderColor)
	{
		this.borderColor=borderColor;
	}
	
	public float calculateCircleArea()
	{
		return 3.14f*rediusCircle*rediusCircle;
	}
	public float getRediusCircle()
	{
		return rediusCircle;
	}
	public BorderColor getBorderColorCircle()
	{
		return borderColor;
	}
	
}
