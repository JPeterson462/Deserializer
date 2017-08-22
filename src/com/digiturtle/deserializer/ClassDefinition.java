package com.digiturtle.deserializer;

import java.util.HashMap;
import java.util.Set;

public class ClassDefinition {
	
	private String className;
	
	private HashMap<String, FieldDefinition<?>> fields = new HashMap<>();
	
	public ClassDefinition(String className) {
		this.className = className;
	}
	
	protected void registerField(String fieldName, FieldDefinition<?> fieldDefinition) {
		fields.put(fieldName, fieldDefinition);
	}
	
	public String getClassName() {
		return className;
	}
	
	public Set<String> getFieldNames() {
		return fields.keySet();
	}
	
	public FieldDefinition<?> getField(String fieldName) {
		return fields.get(fieldName);
	}

}
