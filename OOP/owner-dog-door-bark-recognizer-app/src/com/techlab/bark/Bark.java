package com.techlab.bark;

public class Bark {
	private String sound;
	
	public Bark(String sound)
	{
		this.sound=sound;
	}
	public String getSound()
	{
		return sound;
	}
	public boolean equals(Object bark)
	{
		if (bark instanceof Bark) {
			Bark otherbark=(Bark)bark;
			if(this.sound.equalsIgnoreCase(otherbark.sound))
			{
				return true;
			}
			
		}
		return false;
	}
}
