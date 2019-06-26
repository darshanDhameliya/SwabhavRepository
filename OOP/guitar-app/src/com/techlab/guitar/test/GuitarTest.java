package com.techlab.guitar.test;

import java.util.Iterator;
import java.util.LinkedList;

import com.techlab.guitar.Builder;
import com.techlab.guitar.Guitar;
import com.techlab.guitar.GuitarSpec;
import com.techlab.guitar.Inventory;
import com.techlab.guitar.Type;
import com.techlab.guitar.Wood;

public class GuitarTest {
	public static void main(String args[]) {
		Inventory inventory = new Inventory();
		Guitar guitar;
		GuitarSpec searchGuitarSpec;

		LinkedList<Guitar> matchingGuitars;

		inventory.addGuitar("V95693", 1499.95, Builder.FENDER, "Stratocastor", Type.ELECTRIC, Wood.ALDER, Wood.ALDER);
		inventory.addGuitar("V95694", 1600.50, Builder.FENDER, "Stratocastor", Type.ELECTRIC, Wood.ALDER, Wood.ALDER);
		inventory.addGuitar("V95695", 1799.95, Builder.PRS, "Stratocastor", Type.ACOUSTIC, Wood.BRAZILIAN_ROSEWOOD,
				Wood.INDIAN_ROSEWOOD);

		guitar = inventory.getGuitar("V95694");

		printInfoGuitar(guitar);

		searchGuitarSpec = new GuitarSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC, Wood.ALDER, Wood.ALDER);
		matchingGuitars = inventory.searchGuitar(searchGuitarSpec);

		printSearchGuitar(matchingGuitars);

	}

	public static void printSearchGuitar(LinkedList<Guitar> matchingGuitars) {
		System.out.println("\n-----------search-guitar--------------\n");
	
		if (!matchingGuitars.equals(null)) {
			for (Iterator<Guitar> i = matchingGuitars.iterator(); i.hasNext();) {
				Guitar guitar = (Guitar) i.next();
				printInfoGuitar(guitar);
			}
		}

	}

	public static void printInfoGuitar(Guitar guitar) {
		GuitarSpec guitarSpec = guitar.getGuitarSpec();
		System.out.print("serial number=" + guitar.getSerialNumber());
		System.out.print("\tprice=" + guitar.getPrice());
		System.out.print("\tbuilder=" + guitarSpec.getBuilder());
		System.out.println("\tmodel=" + guitarSpec.getModel());
		System.out.print("type=" + guitarSpec.getType());
		System.out.print("\t\tback wood=" + guitarSpec.getBackwood());
		System.out.println("\ttop wood=" + guitarSpec.getTopwood());
	}

}
