package org.andersonkmi.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/showSettings.action", "/translate.action", "/showTranslations.action", "/upload.action"})
public class AuthenticationFilter implements Filter {

    public AuthenticationFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		
		HttpSession session = servletRequest.getSession(false);
		String isLogged = (String) session.getAttribute("isLogged");
		if(isLogged != null && isLogged.equals("true")) {
			chain.doFilter(request, response);	
		} else {
			servletResponse.sendRedirect(servletRequest.getContextPath() + "/index.jsp");
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
