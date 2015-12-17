package org.andersonkmi.service;

import org.andersonkmi.data.Usuario;
import org.andersonkmi.data.UsuarioDAO;

public class UserService {
	private UsuarioDAO usuarioDAO;
	
	public UserService() {
		usuarioDAO = new UsuarioDAO();
	}

	public Usuario findById(Integer id) {
		return usuarioDAO.findById(id);
	}
	
	public void update(Usuario user) {
		usuarioDAO.updateUser(user);
	}
}
