package com.digiturtle.deserializer;

public interface FieldDefinition<T> {

	public void setValue(T value);
	
	public T getValue();
	
}
