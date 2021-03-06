package com.techlab.guitar;

import java.util.Iterator;
import java.util.LinkedList;

public class Inventory {
	private LinkedList<Guitar> guitars;
	
	public Inventory()
	{
		guitars=new LinkedList<Guitar>();
	}
	public void addGuitar(String serialNumber,Double price,Builder builder,String model,Type type,Wood backWood,Wood topWood)
	{
		Guitar guitar=new Guitar(serialNumber, price, builder, model, type, backWood, topWood);
		
		guitars.add(guitar);
	}
	public Guitar getGuitar(String serialNumber)
	{
		for(Iterator<Guitar> i=guitars.iterator();i.hasNext();)
		{
			Guitar guitar=(Guitar)i.next();
			if(guitar.getSerialNumber().equals(serialNumber))
			{
				return guitar;
			}
		}
		return null;
	}
	public LinkedList<Guitar> searchGuitar(GuitarSpec searchGuitarSpec)
	{
		LinkedList<Guitar> matchingGuitars=new LinkedList<>();
		for(Iterator<Guitar> i=guitars.iterator();i.hasNext();)
		{
			Guitar guitar=(Guitar)i.next();
			GuitarSpec guitarSpec=guitar.getGuitarSpec();

			if (searchGuitarSpec.getBuilder()!=guitarSpec.getBuilder()) 
				continue;
			if (searchGuitarSpec.getModel()!=guitarSpec.getModel()&&!searchGuitarSpec.getModel().equals("")&&searchGuitarSpec.getModel()!=null) 
				continue;
			if (searchGuitarSpec.getType()!=guitarSpec.getType()) 
				continue;
			if (searchGuitarSpec.getBackwood()!=guitarSpec.getBackwood()) 
				continue;
			if (searchGuitarSpec.getTopwood()!=guitarSpec.getTopwood()) 
				continue;
			matchingGuitars.add(guitar);
		}
		return matchingGuitars;
	}
}
