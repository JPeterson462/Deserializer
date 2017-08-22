package com.digiturtle.deserializer;

public class CharFieldDefinition implements FieldDefinition<Character> {

	private char value;
	
	public CharFieldDefinition(char value) {
		this.value = value;
	}
	
	public CharFieldDefinition() {
		
	}
	
	@Override
	public void setValue(Character value) {
		this.value = value;
	}
	
	@Override
	public Character getValue() {
		return value;
	}

}
