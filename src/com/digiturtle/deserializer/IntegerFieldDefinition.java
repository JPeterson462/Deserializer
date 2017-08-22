package com.digiturtle.deserializer;

public class IntegerFieldDefinition implements FieldDefinition<Integer> {

	private int value;
	
	public IntegerFieldDefinition(int value) {
		this.value = value;
	}
	
	public IntegerFieldDefinition() {
		
	}
	
	@Override
	public void setValue(Integer value) { 
		this.value = value;
	}
	
	@Override
	public Integer getValue() {
		return value;
	}

}
