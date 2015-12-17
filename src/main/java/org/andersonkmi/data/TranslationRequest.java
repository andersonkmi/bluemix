package org.andersonkmi.data;

import java.util.Calendar;

public class TranslationRequest {
	private Integer id;
	private Integer userId;
	private String originalText;
	private String translatedText;
	private Calendar requestTimestamp;
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setUserId(Integer id) {
		userId = id;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setOriginalText(String text) {
		originalText = text;
	}
	
	public String getOriginalText() {
		return originalText;
	}
	
	public void setTranslatedText(String text) {
		translatedText = text;
	}
	
	public String getTranslatedText() {
		return translatedText;
	}
	
	public void setRequestTimestamp(Calendar timestamp) {
		requestTimestamp = timestamp;
	}
	
	public Calendar getRequestTimestamp() {
		return requestTimestamp;
	}
}
