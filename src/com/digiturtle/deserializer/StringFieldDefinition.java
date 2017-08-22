package com.digiturtle.deserializer;

public class StringFieldDefinition implements FieldDefinition<String> {

	private String value;
	
	public StringFieldDefinition(String value) {
		this.value = value;
	}
	
	public StringFieldDefinition() {
		
	}
	
	@Override
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String getValue() {
		return value;
	}

}
