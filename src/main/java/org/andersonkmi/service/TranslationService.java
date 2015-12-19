package org.andersonkmi.service;

import java.util.LinkedList;
import java.util.List;

import org.andersonkmi.data.TranslationRequest;
import org.andersonkmi.data.TranslationRequestDAO;

import com.ibm.watson.developer_cloud.language_translation.v2.LanguageTranslation;
import com.ibm.watson.developer_cloud.language_translation.v2.model.Translation;
import com.ibm.watson.developer_cloud.language_translation.v2.model.TranslationResult;

public class TranslationService extends WatsonService {
	private static final String SERVICE_NAME = "language_translation";
	private TranslationRequestDAO requestDAO;
	
	public TranslationService() {
		super();
		requestDAO = new TranslationRequestDAO();
	}
	
	public List<String> translate(String word, Language from, Language to) {
		LanguageTranslation service = new LanguageTranslation();
		WatsonServiceCredentials credentials = findByService(SERVICE_NAME);
		service.setUsernameAndPassword(credentials.getUserName(), credentials.getPassword());
		service.setEndPoint(credentials.getUrl());
		
		TranslationResult result = service.translate(word, from.getLangCode(), to.getLangCode());
		List<Translation> translations = result.getTranslations();
		List<String> translatedWords = new LinkedList<>();
		for(Translation translation : translations) {
			translatedWords.add(translation.getTranslation());
		}
		return translatedWords;
	} 
	
	public TranslationRequest findByUserIdText(Integer userId, String text) {
		return requestDAO.findByUserAndText(userId, text);
	}
	
	public List<TranslationRequest> findByUserId(Integer id) {
		return requestDAO.findByUserId(id);
	}
	
	public void registerTranslationRequest(TranslationRequest request) {
		requestDAO.insert(request);
	}
	
	public List<TranslationRequest> findAll() {
		return requestDAO.findAll();
	}
}
