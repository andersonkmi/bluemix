package org.andersonkmi.service;

import static org.andersonkmi.service.ConversionFormat.HTML;
import static org.andersonkmi.service.ConversionFormat.JSON;
import static org.andersonkmi.service.ConversionFormat.PLAIN_TEXT;

import java.io.File;

import com.ibm.watson.developer_cloud.document_conversion.v1.DocumentConversion;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.Answers;

public class DocumentConversionService extends WatsonService {
	private static final String SERVICE_NAME = "document_conversion";
	public DocumentConversionService() {
		super();
	}
	
	public String convert(File document, ConversionFormat format) {
		String result = "";
		DocumentConversion converter = new DocumentConversion("2015-12-01");
		WatsonServiceCredentials credentials = findByService(SERVICE_NAME);
		converter.setUsernameAndPassword(credentials.getUserName(), credentials.getPassword());
		converter.setEndPoint(credentials.getUrl());
		
		if(format.equals(HTML)) {
			result = converter.convertDocumentToHTML(document);
		} else if(format.equals(PLAIN_TEXT)) {
			result = converter.convertDocumentToText(document);
		} else if(format.equals(JSON)) {
			Answers answers = converter.convertDocumentToAnswer(document);
			result = answers.toString();
		}
		return result;
	}
}
