package com.techlab.dip.solution;

public class TaxCalculator {
	private ILoggable iLoggable;

	public TaxCalculator(ILoggable iLoggable) {
		this.iLoggable = iLoggable;
	}

	public int calculateTax(int amount, int rate) {
		int r = 0;
		try {
			r = amount / rate;
		} catch (Exception e) {
			iLoggable.log("storing exception in");
			return -1;
		}
		return r;
	}
}
