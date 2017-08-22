package com.digiturtle.deserializer;

public class DoubleFieldDefinition implements FieldDefinition<Double> {

	private double value;
	
	public DoubleFieldDefinition(double value) {
		this.value = value;
	}
	
	public DoubleFieldDefinition() {
		
	}
	
	@Override
	public void setValue(Double value) {
		this.value = value;
	}
	
	@Override
	public Double getValue() {
		return value;
	}

}
