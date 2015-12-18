package org.andersonkmi.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class VCAPServicesParserTestCase {
	private VCAPServicesParser parser;
	
	@Before
	public void setup() {
		parser = new VCAPServicesParser();
	}
	
	@Test
	public void testLoadLanguageTranslationOK() {
		String vcapServices = "{\"sqldb\":[{\"name\":\"testdb\",\"label\":\"sqldb\",\"plan\":\"sqldb_free\",\"credentials\":{\"hostname\":\"75.126.155.153\",\"password\":\"KxFj2BR61Ipa\",\"port\":50000,\"host\":\"75.126.155.153\",\"jdbcurl\":\"jdbc:db2://75.126.155.153:50000/SQLDB\",\"uri\":\"db2://user12191:KxFj2BR61Ipa@75.126.155.153:50000/SQLDB\",\"db\":\"SQLDB\",\"username\":\"user12191\"}}],\"language_translation\":[{\"name\":\"Language Translation-4n\",\"label\":\"language_translation\",\"plan\":\"standard\",\"credentials\":{\"url\":\"https://gateway.watsonplatform.net/language-translation/api\",\"username\":\"27a832fc-3df0-4e60-9510-39651270940b\",\"password\":\"13ImZpQevx8u\"}}],\"document_conversion\":[{\"name\":\"Document Conversion-yb\",\"label\":\"document_conversion\",\"plan\":\"standard\",\"credentials\":{\"url\":\"https://gateway.watsonplatform.net/document-conversion/api\",\"username\":\"06bef541-1b30-4e1b-a97a-043e8491e2e4\",\"password\":\"cXP5e4yQ58sM\"}}]}";
		Map<String, WatsonServiceCredential> results = parser.parse(vcapServices);
		assertThat(results.containsKey("language_translation"), is(true));
		assertThat(results.get("language_translation").getUserName(), is("27a832fc-3df0-4e60-9510-39651270940b"));
		assertThat(results.get("language_translation").getPassword(), is("13ImZpQevx8u"));
		assertThat(results.get("language_translation").getUrl(), is("https://gateway.watsonplatform.net/language-translation/api"));
	}
	
	@Test
	public void testLoadDocumentConversionOK() {
		String vcapServices = "{\"sqldb\":[{\"name\":\"testdb\",\"label\":\"sqldb\",\"plan\":\"sqldb_free\",\"credentials\":{\"hostname\":\"75.126.155.153\",\"password\":\"KxFj2BR61Ipa\",\"port\":50000,\"host\":\"75.126.155.153\",\"jdbcurl\":\"jdbc:db2://75.126.155.153:50000/SQLDB\",\"uri\":\"db2://user12191:KxFj2BR61Ipa@75.126.155.153:50000/SQLDB\",\"db\":\"SQLDB\",\"username\":\"user12191\"}}],\"language_translation\":[{\"name\":\"Language Translation-4n\",\"label\":\"language_translation\",\"plan\":\"standard\",\"credentials\":{\"url\":\"https://gateway.watsonplatform.net/language-translation/api\",\"username\":\"27a832fc-3df0-4e60-9510-39651270940b\",\"password\":\"13ImZpQevx8u\"}}],\"document_conversion\":[{\"name\":\"Document Conversion-yb\",\"label\":\"document_conversion\",\"plan\":\"standard\",\"credentials\":{\"url\":\"https://gateway.watsonplatform.net/document-conversion/api\",\"username\":\"06bef541-1b30-4e1b-a97a-043e8491e2e4\",\"password\":\"cXP5e4yQ58sM\"}}]}";
		Map<String, WatsonServiceCredential> results = parser.parse(vcapServices);
		assertThat(results.containsKey("document_conversion"), is(true));
		assertThat(results.get("document_conversion").getUserName(), is("06bef541-1b30-4e1b-a97a-043e8491e2e4"));
		assertThat(results.get("document_conversion").getPassword(), is("cXP5e4yQ58sM"));
		assertThat(results.get("document_conversion").getUrl(), is("https://gateway.watsonplatform.net/document-conversion/api"));
	}

}
