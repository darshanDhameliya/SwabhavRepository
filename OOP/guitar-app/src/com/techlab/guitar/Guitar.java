package com.techlab.guitar;

public class Guitar {
		private String serialNumber;
		private double price;
		GuitarSpec spec;
		
		public Guitar(String serialNumber,double price,Builder builder,String model,Type type,Wood backwood,Wood topwood)
		{
			this.serialNumber=serialNumber;
			this.price=price;
			spec=new GuitarSpec(builder, model, type, backwood, topwood);
		}

		public String getSerialNumber() {
			return serialNumber;
		}

		public double getPrice() {
			return price;
		}
		public GuitarSpec getGuitarSpec()
		{
			return spec;
		}
}
