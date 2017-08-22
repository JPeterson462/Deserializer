package com.digiturtle.deserializer;

public class LongFieldDefinition implements FieldDefinition<Long> {

	private long value;
	
	public LongFieldDefinition(long value) {
		this.value = value;
	}
	
	public LongFieldDefinition() {
		
	}
	
	@Override
	public void setValue(Long value) {
		this.value = value;
	}
	
	@Override
	public Long getValue() {
		return value;
	}

}
