package com.techlab.guitar.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import com.techlab.guitar.Builder;
import com.techlab.guitar.Instrument;
import com.techlab.guitar.InstrumentSpec;
import com.techlab.guitar.InstrumentType;
import com.techlab.guitar.Inventory;
import com.techlab.guitar.Type;
import com.techlab.guitar.Wood;

public class FindInstrument {
	public static void main(String args[]) {
		Inventory inventory = new Inventory();
		initializeInventory(inventory);

		Map properties = new HashMap();
		properties.put("builder", Builder.GIBSON);
		properties.put("backWood", Wood.MAPLE);
		InstrumentSpec clientSpec = new InstrumentSpec((HashMap) properties) {
		};

		LinkedList<Instrument> matchingInstruments = inventory.search(clientSpec);

		if (!matchingInstruments.isEmpty()) {
			System.out.println("You might like these instruments:");
			for (Iterator i = matchingInstruments.iterator(); i.hasNext();) {
				Instrument instrument = (Instrument) i.next();
				InstrumentSpec spec = instrument.getSpec();

				System.out
						.println("We have a " + spec.getProperty("instrumentType") + " with the following properties:");
				for (Iterator j = spec.getProperties().keySet().iterator(); j.hasNext();) {
					String propertyName = (String) j.next();
					if (propertyName.equals("instrumentType"))
						continue;
					System.out.println("   " + propertyName + ": " + spec.getProperty(propertyName));

				}
				System.out.println("  You can have this " + spec.getProperty("instrumentType") + " for $"
						+ instrument.getPrice() + "\n---");
			}

		} else {
			System.out.println("Sorry, we have nothing for you.");
		}
	}

	private static void initializeInventory(Inventory inventory) {
		HashMap properties = new HashMap();
		properties.put("instrumentType", InstrumentType.GUITAR);
		properties.put("builder", Builder.GIBSON);
		properties.put("model", "CJ");
		properties.put("type", Type.ACOUSTIC);
		properties.put("numStrings", 6);
		properties.put("topWood", Wood.INDIAN_ROSEWOOD);
		properties.put("backWood", Wood.MAPLE);
		inventory.addInvertory("11277", 3999.95, new InstrumentSpec(properties) {
		});

		properties.put("builder", Builder.GIBSON);
		properties.put("model", "D-18");
		properties.put("topWood", Wood.MAHOGANY);
		properties.put("backWood", Wood.MAPLE);
		inventory.addInvertory("122784", 5495.95, new InstrumentSpec(properties) {
		});

	}

	// public static void printSearch(LinkedList<Instrument> matchingGuitars) {
	// System.out.println("\n-----------search-guitar--------------\n");
	//
	// if (!matchingGuitars.equals(null)) {
	// for (Iterator<Instrument> i = matchingGuitars.iterator(); i.hasNext();) {
	// Guitar guitar = (Guitar) i.next();
	// printInfo(guitar);
	// }
	// }
	//
	// }

	// public static void printInfo(Instrument instrument) {
	// InstrumentSpec instrumentSpec = instrument.getSpec();
	// System.out.print("serial number=" + instrument.getSerialNumber());
	// System.out.print("\tprice=" + instrument.getPrice());
	// System.out.print("\tbuilder=" + instrumentSpec.getBuilder());
	// System.out.println("\tmodel=" + instrumentSpec.getModel());
	// System.out.print("type=" + instrumentSpec.getType());
	// System.out.print("\t\tback wood=" + instrumentSpec.getBackwood());
	// System.out.println("\ttop wood=" + instrumentSpec.getTopwood());
	// }

}
