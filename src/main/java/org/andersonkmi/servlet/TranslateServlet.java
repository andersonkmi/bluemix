package org.andersonkmi.servlet;

import static org.andersonkmi.service.Language.ENGLISH;
import static org.andersonkmi.service.Language.PORTGUESE;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.andersonkmi.data.TranslationRequest;
import org.andersonkmi.service.TranslationService;

@WebServlet("/translate.action")
public class TranslateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TranslateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if("showResults".equals(action)) {
			String originalText = request.getParameter("originalText");
			String translatedText = performTranslation(originalText);
			registerTranslationRequest(originalText, translatedText, (Integer) request.getSession(false).getAttribute("id")); 
			request.setAttribute("translatedText", translatedText);		
			request.setAttribute("originalText", originalText);
		}
		request.getRequestDispatcher("/WEB-INF/translate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private String performTranslation(String originalText) {
		TranslationService translation = new TranslationService();
		List<String> words = translation.translate(originalText, PORTGUESE, ENGLISH);
		StringBuffer buffer = new StringBuffer();
		for(String word : words) {
			buffer.append(word).append(" ");
		}
		return buffer.toString();
	}
	
	private void registerTranslationRequest(String originalText, String translatedText, Integer userId) {
		TranslationRequest request = new TranslationRequest();
		request.setUserId(userId);
		request.setOriginalText(originalText);
		request.setTranslatedText(translatedText);
		request.setRequestTimestamp(Calendar.getInstance());
		TranslationService service = new TranslationService();
		service.registerTranslationRequest(request);
	}
}
