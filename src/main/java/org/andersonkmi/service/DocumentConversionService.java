package org.andersonkmi.service;

import static org.andersonkmi.service.ConversionFormat.HTML;
import static org.andersonkmi.service.ConversionFormat.JSON;
import static org.andersonkmi.service.ConversionFormat.PLAIN_TEXT;

import java.io.File;

import com.ibm.watson.developer_cloud.document_conversion.v1.DocumentConversion;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.Answers;

public class DocumentConversionService {
	private String endPoint;
	private String userName;
	private String password;
	
	public DocumentConversionService() {
		
	}
	public String convert(File document, ConversionFormat format) {
		String result = "";
		DocumentConversion converter = new DocumentConversion();
		converter.setUsernameAndPassword("06bef541-1b30-4e1b-a97a-043e8491e2e4", "cXP5e4yQ58sM");
		converter.setEndPoint("https://gateway.watsonplatform.net/document-conversion/api");
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
