package org.andersonkmi.service;

import java.util.LinkedList;
import java.util.List;

import com.ibm.watson.developer_cloud.language_translation.v2.LanguageTranslation;
import com.ibm.watson.developer_cloud.language_translation.v2.model.Translation;
import com.ibm.watson.developer_cloud.language_translation.v2.model.TranslationResult;

public class TranslationService {
	
	public List<String> translate(String word, Language from, Language to) {
		LanguageTranslation service = new LanguageTranslation();
		service.setUsernameAndPassword("27a832fc-3df0-4e60-9510-39651270940b", "13ImZpQevx8u");
		TranslationResult result = service.translate(word, from.getLangCode(), to.getLangCode());
		List<Translation> translations = result.getTranslations();
		List<String> translatedWords = new LinkedList<>();
		for(Translation translation : translations) {
			translatedWords.add(translation.getTranslation());
		}
		return translatedWords;
	}
}
