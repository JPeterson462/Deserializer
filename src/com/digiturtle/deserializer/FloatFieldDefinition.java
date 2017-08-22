package com.digiturtle.deserializer;

public class FloatFieldDefinition implements FieldDefinition<Float> {

	private float value;
	
	public FloatFieldDefinition(float value) {
		this.value = value;
	}
	
	public FloatFieldDefinition() {
		
	}
	
	@Override
	public void setValue(Float value) {
		this.value = value;
	}
	
	@Override
	public Float getValue() {
		return value;
	}

}
