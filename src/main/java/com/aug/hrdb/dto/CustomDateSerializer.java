package com.aug.hrdb.dto;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;



public class CustomDateSerializer extends JsonSerializer<Object> {

	

	@Override
	public void serialize(Object value, JsonGenerator jsonGenerator,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			Date date = (Date)value;
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String formattedDate = formatter.format(date);

		jsonGenerator.writeString(formattedDate);
		
		System.out.println(jsonGenerator);
	}
}