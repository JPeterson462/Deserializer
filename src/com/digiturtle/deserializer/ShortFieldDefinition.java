package com.digiturtle.deserializer;

public class ShortFieldDefinition implements FieldDefinition<Short> {

	private short value;
	
	public ShortFieldDefinition(short value) {
		this.value = value;
	}
	
	public ShortFieldDefinition() {
		
	}
	
	@Override
	public void setValue(Short value) {
		this.value = value;
	}
	
	@Override
	public Short getValue() {
		return value;
	}

}
