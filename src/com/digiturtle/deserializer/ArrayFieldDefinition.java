package com.digiturtle.deserializer;

public class ArrayFieldDefinition<T> implements FieldDefinition<FieldDefinition<T>[]> {

	private FieldDefinition<T>[] value;
	
	public ArrayFieldDefinition(FieldDefinition<T>[] value) {
		this.value = value;
	}
	
	public ArrayFieldDefinition() {
		
	}
	
	@Override
	public void setValue(FieldDefinition<T>[] value) {
		this.value = value;
	}
	
	@Override
	public FieldDefinition<T>[] getValue() {
		return value;
	}

}
