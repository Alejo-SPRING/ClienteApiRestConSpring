package com.consumApi.backEnd.app.web.jsonObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Contenedor {
	
	@JsonProperty(value = "@odata.context")
	private String type;
	private Value value;
	
	public Contenedor() {
		
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Value getValue() {
		return value;
	}

	public void setValue(Value value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Contenedor [type=" + type + ", value=" + value + ", toString()=" + value.toString() + "]";
	}
	
}
