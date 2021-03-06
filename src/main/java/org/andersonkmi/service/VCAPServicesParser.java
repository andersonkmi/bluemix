package org.andersonkmi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import flexjson.JSONDeserializer;

public class VCAPServicesParser {
	private JSONDeserializer<Map<String, List<Map<String, Map<String, String>>>>> jsonDeserializer = new JSONDeserializer<>();

	public Map<String, WatsonServiceCredentials> parse(String vcapServices) {
		Map<String, WatsonServiceCredentials> results = new HashMap<>();
		Map<String, List<Map<String, Map<String, String>>>> parsedElements = jsonDeserializer.deserialize(vcapServices);
		loadLanguageTranslation(results, parsedElements);
		loadDocumentConversion(results, parsedElements);
		return results;
	}
	
	private void loadLanguageTranslation(Map<String, WatsonServiceCredentials> results, Map<String, List<Map<String, Map<String, String>>>> parsedElements) {
		loadVCAPServicesCredentials(results, parsedElements, "language_translation");
	}
	
	private void loadDocumentConversion(Map<String, WatsonServiceCredentials> results, Map<String, List<Map<String, Map<String, String>>>> parsedElements) {
		loadVCAPServicesCredentials(results, parsedElements, "document_conversion");
	}
	
	private void loadVCAPServicesCredentials(Map<String, WatsonServiceCredentials> results, Map<String, List<Map<String, Map<String, String>>>> parsedElements, String service) {
		if(parsedElements.containsKey(service)) {
			String userName = parsedElements.get(service).get(0).get("credentials").get("username");
			String password = parsedElements.get(service).get(0).get("credentials").get("password");
			String url = parsedElements.get(service).get(0).get("credentials").get("url");
			WatsonServiceCredentials credential = new WatsonServiceCredentials();
			credential.setUserName(userName);
			credential.setPassword(password);
			credential.setUrl(url);
			
			results.put(service, credential);
		}
	}
}
