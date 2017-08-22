package com.digiturtle.deserializer;

public enum FieldType {
	
	OBJECT,
	
	CLASSDESC;
	
	public static FieldType readFromShort(short value) {
		if (value == 0x73) {
			return OBJECT;
		}
		if (value == 0x72) {
			return CLASSDESC;
		}
		return null;
	}

}
