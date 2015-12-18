package org.andersonkmi.service;

public enum ConversionFormat {
	
	HTML("html"),
	PLAIN_TEXT("plain"),
	JSON("json");
	
	private String formatName;
	
	private ConversionFormat(String format) {
		formatName = format;
	}
	
	public String getFormatName() {
		return formatName;
	}
	
	public static ConversionFormat findByFormatName(String format) {
		for(ConversionFormat item : values()) {
			if(item.getFormatName().equals(format)) {
				return item;
			}
		}
		return HTML;
	}
}
