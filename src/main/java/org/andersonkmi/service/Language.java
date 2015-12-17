package org.andersonkmi.service;

public enum Language {
	ENGLISH("en"),
	SPANISH("es"),
	PORTGUESE("pt");
	
	private String languageCode;
	
	private Language(String code) {
		languageCode = code;
	}
	
	public String getLangCode() {
		return languageCode;
	}
}
