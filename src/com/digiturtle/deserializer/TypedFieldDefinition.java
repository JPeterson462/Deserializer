package com.digiturtle.deserializer;

public class TypedFieldDefinition implements FieldDefinition<ClassDefinition> {
	
	private ClassDefinition fieldValue;
	
	private long serialVersionUID;
	
	private byte flags;
	
	public TypedFieldDefinition(ClassDefinition fieldValue, long serialVersionUID, byte flags) {
		this.fieldValue = fieldValue;
		this.serialVersionUID = serialVersionUID;
		this.flags = flags;
	}
	
	public TypedFieldDefinition() {
		
	}
	
	public void setValue(ClassDefinition fieldValue) {
		this.fieldValue = fieldValue;
	}
	
	public ClassDefinition getValue() {
		return fieldValue;
	}
	
	public void setSerialVersionUID(long serialVersionUID) {
		this.serialVersionUID = serialVersionUID;
	}
	
	public long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	public void setFlags(byte flags) {
		this.flags = flags;
	}
	
	public byte getFlags() {
		return flags;
	}

}
