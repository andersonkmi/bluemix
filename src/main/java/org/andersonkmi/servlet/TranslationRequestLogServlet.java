package org.andersonkmi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.andersonkmi.data.TranslationRequest;
import org.andersonkmi.service.TranslationService;

@WebServlet("/showTranslations.action")
public class TranslationRequestLogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TranslationRequestLogServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TranslationService service = new TranslationService();
		List<TranslationRequest> items = service.findByUserId((Integer) request.getSession(false).getAttribute("id"));
		request.setAttribute("translationRequests", items);
		request.getRequestDispatcher("/WEB-INF/showTranslations.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
