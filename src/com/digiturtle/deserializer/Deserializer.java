package com.digiturtle.deserializer;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

// http://www.javaworld.com/article/2072752/the-java-serialization-algorithm-revealed.html
public class Deserializer {
	
	public static TypedFieldDefinition readFromStream(InputStream stream) throws IOException {
		short streamMagic = readPair(stream);
//		short streamVersion = readPair(stream);
		if (streamMagic != 0xACED) {
			throw new IllegalStateException("Invalid serialization magic");
		}
		FieldType type = FieldType.readFromShort((short) stream.read());
		if (type.equals(FieldType.OBJECT)) {
			ArrayList<FieldDefinition<?>> dataFields = new ArrayList<>();
			TypedFieldDefinition definition = readTypedField((short) stream.read(), stream, dataFields);
			// read values
			return definition;
		}
		return null;
	}
	
	private static TypedFieldDefinition readTypedField(short typeEnum, InputStream stream, ArrayList<FieldDefinition<?>> dataFields) throws IOException {
		FieldType type = FieldType.readFromShort(typeEnum);
		if (type.equals(FieldType.CLASSDESC)) {
			String className = readString(stream);
			long serialVersionUID = readLong(stream);
			byte flags = (byte) (stream.read() & 0xFF);
			short numberOfFields = readPair(stream);
			ClassDefinition classDefinition = new ClassDefinition(className);
			ArrayList<String> fieldNames = new ArrayList<>();
			for (int i = 0 ; i < numberOfFields; i++) {
				byte fieldTypeCode = (byte) (stream.read() & 0xFF);
				String fieldName = readString(stream);
				fieldNames.add(fieldName);
				FieldDefinition<?> fieldDefinition = readField(stream, fieldTypeCode);
				classDefinition.registerField(fieldName, fieldDefinition);
				dataFields.add(fieldDefinition);
			}
			TypedFieldDefinition definition = new TypedFieldDefinition(classDefinition, serialVersionUID, flags);
			return definition;
		}
		return null;
	}
	
	private static FieldDefinition<?> readField(InputStream stream, byte fieldTypeCode) throws IOException {
		if (fieldTypeCode == 0x49) {
			return new IntegerFieldDefinition();
		}
		if (fieldTypeCode == 0x74) {
			readPair(stream); // read TC_ENDBLOCKDATA
			return new StringFieldDefinition();
		}
		return null;
		
	}
	
	private static short readPair(InputStream stream) throws IOException {
		byte b0 = (byte) (stream.read() & 0xFF);
		byte b1 = (byte) (stream.read() & 0xFF);
		return (short) ((b0 << 8) | b1);
	}
	
	private static long readLong(InputStream stream) throws IOException {
		byte b0 = (byte) (stream.read() & 0xFF);
		byte b1 = (byte) (stream.read() & 0xFF);
		byte b2 = (byte) (stream.read() & 0xFF);
		byte b3 = (byte) (stream.read() & 0xFF);
		byte b4 = (byte) (stream.read() & 0xFF);
		byte b5 = (byte) (stream.read() & 0xFF);
		byte b6 = (byte) (stream.read() & 0xFF);
		byte b7 = (byte) (stream.read() & 0xFF);
		return (long) ((b0 << 56) | (b1 << 48) | (b2 << 40) | (b3 << 32) |
				(b4 << 24) | (b5 << 16) | (b6 << 8) | (b7));
	}
	
	private static String readString(InputStream stream) throws IOException {
		return readString(stream, (int) readPair(stream));
	}
	
	private static String readString(InputStream stream, int length) throws IOException {
		byte[] bytes = new byte[length];
		stream.read(bytes);
		return new String(bytes);
	}

}
