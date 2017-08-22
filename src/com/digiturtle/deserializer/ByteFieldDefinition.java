package com.digiturtle.deserializer;

public class ByteFieldDefinition implements FieldDefinition<Byte> {

	private byte value;
	
	public ByteFieldDefinition(byte value) {
		this.value = value;
	}
	
	public ByteFieldDefinition() {
		
	}
	
	@Override
	public void setValue(Byte value) {
		this.value = value;
	}
	
	@Override
	public Byte getValue() {
		return value;
	}

}
