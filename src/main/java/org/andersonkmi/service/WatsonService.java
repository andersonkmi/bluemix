package org.andersonkmi.service;

import java.util.HashMap;
import java.util.Map;

public class WatsonService {
	
	private Map<String, WatsonServiceCredentials> serviceCredentials = new HashMap<>();
	private VCAPServicesParser parser = new VCAPServicesParser();
	
	public WatsonService() {
		String vcapServices = System.getenv("VCAP_SERVICES");
		if(vcapServices != null && !vcapServices.isEmpty()) {
			serviceCredentials = parser.parse(vcapServices);
		}
	}
	
	public WatsonServiceCredentials findByService(String service) {
		return serviceCredentials.get(service);
	}
}
