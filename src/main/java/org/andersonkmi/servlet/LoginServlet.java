package org.andersonkmi.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.andersonkmi.data.Usuario;
import org.andersonkmi.service.InvalidLoginOrPasswordException;
import org.andersonkmi.service.LoginService;

@WebServlet("/login.action")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginService controller = new LoginService();
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
			controller.login(userName, password);
			Usuario loggedUser = controller.findUser(userName);
			request.getSession().setAttribute("userName", loggedUser.getName());
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			request.getSession().setAttribute("lastAccess", sdf.format(loggedUser.getLastAccess().getTime()));
			StringBuffer buffer = new StringBuffer();
			buffer.append(loggedUser.getName()).append(" (").append(loggedUser.getLogin()).append(")");
			request.getSession().setAttribute("userName", buffer.toString());
			request.getSession().setAttribute("isLogged", "true");
			request.getSession().setAttribute("id", loggedUser.getId());
			request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
		} catch (InvalidLoginOrPasswordException exception) {
			request.setAttribute("errorMessage", "Invalid login and/or password.");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
