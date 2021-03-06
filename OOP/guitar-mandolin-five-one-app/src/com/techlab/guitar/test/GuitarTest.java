package com.techlab.guitar.test;

import java.util.Iterator;
import java.util.LinkedList;

import com.techlab.guitar.Builder;
import com.techlab.guitar.Guitar;
import com.techlab.guitar.GuitarSpec;
import com.techlab.guitar.Instrument;
import com.techlab.guitar.InstrumentSpec;
import com.techlab.guitar.Inventory;
import com.techlab.guitar.Type;
import com.techlab.guitar.Wood;

public class GuitarTest {
	public static void main(String args[]) {
		Inventory inventory = new Inventory();
		Instrument instrument;
		InstrumentSpec instrumentSpec;

		LinkedList<Instrument> matchingGuitars;

		inventory.addInvertory("V95694", 1600.50,
				new GuitarSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC, 12, Wood.ALDER, Wood.ALDER));
		inventory.addInvertory("V95693", 1499.95,
				new GuitarSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC, 12, Wood.ALDER, Wood.ALDER));
		inventory.addInvertory("V95695", 1799.95, new GuitarSpec(Builder.PRS, "Stratocastor", Type.ACOUSTIC, 10,
				Wood.BRAZILIAN_ROSEWOOD, Wood.INDIAN_ROSEWOOD));
		instrument = inventory.get("V95694");

		printInfo(instrument);
		instrumentSpec = new InstrumentSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC, Wood.ALDER, Wood.ALDER) {
		};

		GuitarSpec searchGuitarSpec=new GuitarSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC,12, Wood.ALDER, Wood.ALDER);
		matchingGuitars = inventory.searchGuitar(searchGuitarSpec);

		printSearch(matchingGuitars);

	}

	public static void printSearch(LinkedList<Instrument> matchingGuitars) {
		System.out.println("\n-----------search-guitar--------------\n");

		if (!matchingGuitars.equals(null)) {
			for (Iterator<Instrument> i = matchingGuitars.iterator(); i.hasNext();) {
				Guitar guitar = (Guitar) i.next();
				printInfo(guitar);
			}
		}

	}

	public static void printInfo(Instrument instrument) {
		InstrumentSpec instrumentSpec = instrument.getSpec();
		System.out.print("serial number=" + instrument.getSerialNumber());
		System.out.print("\tprice=" + instrument.getPrice());
		System.out.print("\tbuilder=" + instrumentSpec.getBuilder());
		System.out.println("\tmodel=" + instrumentSpec.getModel());
		System.out.print("type=" + instrumentSpec.getType());
		System.out.print("\t\tback wood=" + instrumentSpec.getBackwood());
		System.out.println("\ttop wood=" + instrumentSpec.getTopwood());
	}

}
