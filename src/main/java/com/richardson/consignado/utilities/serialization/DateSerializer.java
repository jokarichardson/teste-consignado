package com.richardson.consignado.utilities.serialization;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class DateSerializer extends JsonSerializer<LocalDate> {

	public DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	@Override
	public void serialize(LocalDate date, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException {
		String dateFormatted = this.dtf.format(date);
		jsonGenerator.writeString(dateFormatted);
	}
}
