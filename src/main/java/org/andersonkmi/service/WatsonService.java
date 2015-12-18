package org.andersonkmi.service;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class WatsonService {
	
	private Map<String, WatsonServiceCredential> serviceCredentials = new HashMap<>();
	
	public WatsonService() {
		String vcapServices = System.getenv("VCAP_SERVICES");
		if(vcapServices != null && !vcapServices.isEmpty()) {
			JsonElement element = new JsonParser().parse(vcapServices);
			if(element.isJsonObject()) {
				JsonObject jsonObj = element.getAsJsonObject();
				
			}
		}
	}
}
