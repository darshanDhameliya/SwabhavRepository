package com.techlab.guitar;

import java.util.Iterator;
import java.util.LinkedList;


public class Inventory {
	private LinkedList<Instrument> inventory;

	public Inventory() {
		inventory = new LinkedList<Instrument>();
	}

	public void addInvertory(String serialNumber, Double price, InstrumentSpec instrumentSpec) {
		Instrument instrument = null;
		if (instrumentSpec instanceof GuitarSpec) {
			instrument = new Guitar(serialNumber, price, (GuitarSpec) instrumentSpec);
		}
		if (instrumentSpec instanceof MandolinSpec) {
			instrument = new Mandolin(serialNumber, price, (MandolinSpec) instrumentSpec);
		}

		inventory.add(instrument);
	}

	public Instrument get(String serialNumber) {
		for (Iterator<Instrument> i = inventory.iterator(); i.hasNext();) {
			Instrument instrument = (Instrument) i.next();
			if (instrument.getSerialNumber().equals(serialNumber))
				return instrument;
		}
		return null;
	}
	

	public LinkedList<Instrument> searchMandolin(MandolinSpec searchSpec) {
		LinkedList<Instrument> matchingMandolins = new LinkedList<Instrument>();
		for (Iterator<Instrument> i = inventory.iterator(); i.hasNext();) {
			Mandolin mandolin = (Mandolin) i.next();
			if (mandolin.getSpec().matches(searchSpec)) {
				matchingMandolins.add(mandolin);
			}

		}
		return matchingMandolins;
	}

	public LinkedList<Instrument> searchGuitar(GuitarSpec searchSpec) {
		LinkedList<Instrument> matchingGuitars = new LinkedList<Instrument>();
		for (Iterator<Instrument> i = inventory.iterator(); i.hasNext();) {
			Guitar guitar = (Guitar) i.next();
			if (guitar.getSpec().matches(searchSpec)) {
				matchingGuitars.add(guitar);
			}

		}
		return matchingGuitars;
	}
}
