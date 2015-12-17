package org.andersonkmi.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

public class UsuarioDAO extends BaseDAO {
	public UsuarioDAO() {
		super();
	}
	
	public Usuario findByLogin(String login) {
		
		Usuario usuario = null;
		String statement = "SELECT ID, LOGIN, NOME, PASSWORD, LAST_ACCESS FROM USUARIO WHERE LOGIN = ?";
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement query = connection.prepareStatement(statement);
			query.setString(1, login);
			ResultSet rs = query.executeQuery();
			while(rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("ID"));
				usuario.setName(rs.getString("NOME"));
				usuario.setLogin(login);
				usuario.setPassword(rs.getString("PASSWORD"));
				
				Timestamp lastAccessTs = rs.getTimestamp("LAST_ACCESS");
				if(lastAccessTs != null) {
					Calendar lastAccess = Calendar.getInstance();
					lastAccess.setTimeInMillis(lastAccessTs.getTime());
					usuario.setLastAccess(lastAccess);					
				}
			}
			rs.close();
		} catch (SQLException exception) {
			StringBuffer buffer = new StringBuffer();
			buffer.append("An error has occurred when searching for the user = '").append(login).append("'");
			System.err.println(buffer.toString() + " - " + exception.getMessage());
		} finally {
			if(connection != null) {
				try { 
					connection.close();
				} catch (SQLException exception) {}
			}
		}
		return usuario;			
	}
	
	public Usuario findById(Integer id) {
		
		Usuario usuario = null;
		String statement = "SELECT ID, LOGIN, NOME, PASSWORD, LAST_ACCESS FROM USUARIO WHERE ID = ?";
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement query = connection.prepareStatement(statement);
			query.setInt(1, id);
			ResultSet rs = query.executeQuery();
			while(rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("ID"));
				usuario.setName(rs.getString("NOME"));
				usuario.setLogin(rs.getString("LOGIN"));
				usuario.setPassword(rs.getString("PASSWORD"));
				
				Timestamp lastAccessTs = rs.getTimestamp("LAST_ACCESS");
				if(lastAccessTs != null) {
					Calendar lastAccess = Calendar.getInstance();
					lastAccess.setTimeInMillis(lastAccessTs.getTime());
					usuario.setLastAccess(lastAccess);					
				}
			}
			rs.close();
		} catch (SQLException exception) {
			StringBuffer buffer = new StringBuffer();
			buffer.append("An error has occurred when searching for the user = '").append(id).append("'");
			System.err.println(buffer.toString() + " - " + exception.getMessage());
		} finally {
			if(connection != null) {
				try { 
					connection.close();
				} catch (SQLException exception) {}
			}
		}
		return usuario;			
	}	
	
	public void updateLastAccess(Usuario user) {
		String updateStatement = "UPDATE USUARIO SET LAST_ACCESS = ? WHERE ID = ?";		
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(updateStatement);
			statement.setTimestamp(1, new Timestamp(Calendar.getInstance().getTimeInMillis()));
			statement.setInt(2, user.getId());
			statement.executeUpdate();
		} catch (SQLException exception) {
			StringBuffer buffer = new StringBuffer();
			buffer.append("An error has occurred when updating last access for user = '").append(user.getLogin()).append("'");
			System.err.println(buffer.toString() + " - " + exception.getMessage());
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}				
			} catch (SQLException exception) {}
		}
		 
	}
	
	public void updateUser(Usuario user) {
		String updateStatement = "UPDATE USUARIO SET NOME = ?, LOGIN = ? WHERE ID = ?";
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(updateStatement);
			statement.setTimestamp(1, new Timestamp(Calendar.getInstance().getTimeInMillis()));
			statement.setInt(2, user.getId());
			statement.executeUpdate();
		} catch (SQLException exception) {
			StringBuffer buffer = new StringBuffer();
			buffer.append("An error has occurred when updating user = '").append(user.getLogin()).append("'");
			System.err.println(buffer.toString() + " - " + exception.getMessage());
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}				
			} catch (SQLException exception) {}
		}
		
	}
}
