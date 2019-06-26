package com.techlab.guitar;

public class MandolinSpec extends InstrumentSpec{
	
	private Style style;
	public MandolinSpec(Builder builder,String model,Type type,Style style,Wood backwood,Wood topwood)
	{
		super(builder, model, type, backwood, topwood);
		this.style=style;
	}
	
	public Style getStyle() {
		return style;
	}
	public boolean matches(InstrumentSpec otherSpec)
	{
		if(!super.matches(otherSpec))
			return false;
		if(!(otherSpec instanceof MandolinSpec))
			return false;
		MandolinSpec spec=(MandolinSpec) otherSpec;
		if (!style.equals(spec.style))
			return false;
		return true;
	}

}
