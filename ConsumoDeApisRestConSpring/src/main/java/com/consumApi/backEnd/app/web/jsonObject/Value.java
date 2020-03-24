package com.consumApi.backEnd.app.web.jsonObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Value {

	private Long id;
	private String content;
	
	public Value() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuote() {
		return content;
	}

	public void setQuote(String quote) {
		this.content = quote;
	}

	@Override
	public String toString() {
		return "Value [id=" + id + ", quote=" + content + "]";
	}
	
}
