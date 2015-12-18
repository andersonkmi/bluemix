package org.andersonkmi.service;

import org.andersonkmi.data.Usuario;
import org.andersonkmi.data.UsuarioDAO;

public class LoginService {
	private UsuarioDAO usuarioDAO;
	
	public LoginService() {
		usuarioDAO = new UsuarioDAO();
	}
	
	public void login(String user, String password) throws InvalidLoginOrPasswordException {
		String vcapServices = System.getenv("VCAP_SERVICES");
		if(vcapServices != null) {
			productionLogin(user, password);
		}
		developmentLogin(user, password);
	}
	
	private void developmentLogin(String user, String password) throws InvalidLoginOrPasswordException {
		if(user.isEmpty() || password.isEmpty()) {
			throw new InvalidLoginOrPasswordException("Invalid login or password");	
		}
	}
	
	private void productionLogin(String user, String password) throws InvalidLoginOrPasswordException {
		System.out.println("***** Usando procedimento produtivo *****");
		Usuario usuario = findUser(user);
		
		if(usuario != null) {
			System.out.println("Usuario encontrado na base");
			if(!isPasswordValid(password, usuario.getPassword())) {
				System.err.println("Senha invalida");
				throw new InvalidLoginOrPasswordException("Invalid login or password");
			} else {
				registerCurrentAccess(usuario);
			}
		} else {
			throw new InvalidLoginOrPasswordException("Invalid login or password");
		}
				
	}
	
	public Usuario findUser(String login) {
		return usuarioDAO.findByLogin(login);
	}
	
	private boolean isPasswordValid(String suppliedPassword, String retrievedPassword) {
		return retrievedPassword.trim().equals(suppliedPassword.trim());
	}
	
	private void registerCurrentAccess(Usuario user) {
		usuarioDAO.updateLastAccess(user);
	}
}
