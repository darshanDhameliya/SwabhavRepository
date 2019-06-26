package com.techlab.guitar;

import java.util.Iterator;
import java.util.LinkedList;

public class Inventory {
	private LinkedList<Instrument> inventory;

	public Inventory() {
		inventory = new LinkedList<Instrument>();
	}

	public void addInvertory(String serialNumber, Double price, InstrumentSpec instrumentSpec) {
		Instrument instrument=new Instrument(serialNumber,price,instrumentSpec) {
		};
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

	public LinkedList<Instrument> search(InstrumentSpec searchSpec) {
		LinkedList<Instrument> matchingInstruments = new LinkedList<Instrument>();
		for (Iterator<Instrument> i = inventory.iterator(); i.hasNext();) {
			Instrument instrument = (Instrument) i.next();
			if (instrument.getSpec().matches(searchSpec)) {
				matchingInstruments.add(instrument);
			}

		}
		return matchingInstruments;
	}


}
