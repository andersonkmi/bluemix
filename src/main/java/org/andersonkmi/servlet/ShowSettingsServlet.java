package org.andersonkmi.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.andersonkmi.data.Usuario;
import org.andersonkmi.service.UserService;

@WebServlet("/showSettings.action")
public class ShowSettingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowSettingsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService service = new UserService();
		Integer id = Integer.valueOf(request.getParameter("id"));
		Usuario usuario = service.findById(id);
		request.setAttribute("userId", usuario.getId());
		request.setAttribute("login", usuario.getLogin());
		request.setAttribute("name", usuario.getName());
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		request.setAttribute("lastAccess", sdf.format(usuario.getLastAccess().getTime()));
		request.getRequestDispatcher("/WEB-INF/showSettings.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
