package com.techlab.human;

public class Human {
	private String name;
	private int age;
	private float height, weight, humanBMI;
	private GenderType gender;

	private static int humanCount = 0;

	final float HEIGHT_GAIN_PERSENTAGE = 0.05f;
	final float WEIGHT_GAIN_PERSENTAGE = 0.01f;
	final float WEIGHT_LOSS_PERSENTAGE = 0.02f;

	final float MAX_EMI_UNDERWEIGHT = 18.4f;
	final float MAX_EMI_HEALTHYWEIGHT = 24.9f;
	final float MAX_EMI_OVERWEIGHT = 29.9f;
	
	static {
		System.out.println("static block");
	}
	public Human(String name, int age, float height, float weight, GenderType gender) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.gender = gender;
		humanCount++;
		System.out.println("constractor");
	}

	public Human(String name, int age) {
		this(name, age, 5, 50, GenderType.MALE);
	}

	public String getHumanName() {
		return name;
	}

	public int getHumanAge() {
		return age;
	}

	public float getHumanHeight() {
		return height;
	}

	public float getHumanWeight() {
		return weight;
	}

	public GenderType getHumanGender() {
		return gender;
	}

	public void humanWorkout() {
		weight -= WEIGHT_LOSS_PERSENTAGE * weight;
	}

	public void humanEat() {
		height += HEIGHT_GAIN_PERSENTAGE * height;
		weight += WEIGHT_GAIN_PERSENTAGE * weight;
	}

	public float calculateBMI() {
		float heightConvertMeter = height * 0.3048f;
		humanBMI = weight / (heightConvertMeter * heightConvertMeter);
		return humanBMI;
	}

	public String getBodyCategories() {

		if (humanBMI <= MAX_EMI_UNDERWEIGHT)
			return "Under Weight";
		if (humanBMI <= MAX_EMI_HEALTHYWEIGHT)
			return "Healthy Weight";
		if (humanBMI <= MAX_EMI_OVERWEIGHT)
			return "Over Weight";
		return "Obese";

	}

	public Human whoIsElder(Human human2) {
		if (this.age > human2.age)
			return this;
		return human2;
	}

	public static int headCount() {
		return humanCount;
	}

}
