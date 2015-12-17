package org.andersonkmi.data;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BaseDAO {
	@Resource(lookup="jdbc/testdb")
	private DataSource dataSource;
	
	public BaseDAO() {
		try {
			InitialContext context = new InitialContext();
			dataSource = (DataSource) context.lookup("jdbc/testdb");			
		} catch (Exception exception) {}
	}
		
	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}
