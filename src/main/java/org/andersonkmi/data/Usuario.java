package org.andersonkmi.data;

import java.io.Serializable;
import java.util.Calendar;

public class Usuario implements Serializable {
	private static final long serialVersionUID = -1261913229135272838L;

	private Integer id;
	private String login;
	private String password;
	private String name;
	private Calendar lastAccess;
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setPassword(String pwd) {
		password = pwd;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setLastAccess(Calendar info) {
		lastAccess = info;
	}
	
	public Calendar getLastAccess() {
		return lastAccess;
	}
}
