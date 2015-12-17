package org.andersonkmi.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TranslationRequestDAO extends BaseDAO {
	public TranslationRequestDAO() {
		super();
	}
	
	public void insert(TranslationRequest request) {
		String statement = "INSERT INTO TRANSLATION_REQUESTS(USER_ID, ORIGINAL_TEXT, TRANSLATED_TEXT, REQ_TIMESTAMP) VALUES (?, ?, ?, ?)";
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement insertStatement = connection.prepareStatement(statement);
			insertStatement.setInt(1, request.getUserId());
			insertStatement.setString(2, request.getOriginalText());
			insertStatement.setString(3,  request.getTranslatedText());
			insertStatement.setTimestamp(4, new Timestamp(request.getRequestTimestamp().getTimeInMillis()));
			insertStatement.executeUpdate();
		} catch (SQLException exception) {
			StringBuffer buffer = new StringBuffer();
			buffer.append("An error has occurred when inserting a new request.");
			System.err.println(buffer.toString() + " - " + exception.getMessage());
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException exception) {}
		}
	}
	
	public List<TranslationRequest> findAll() {
		List<TranslationRequest> results = new ArrayList<>();
		String statement = "SELECT ID, USER_ID, ORIGINAL_TEXT, TRANSLATED_TEXT, REQ_TIMESTAMP FROM TRANSLATION_REQUESTS";
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement query = connection.prepareStatement(statement);
			ResultSet rs = query.executeQuery();
			while(rs.next()) {
				TranslationRequest request = new TranslationRequest();
				request.setId(rs.getInt("ID"));
				request.setUserId(rs.getInt("USER_ID"));
				request.setOriginalText(rs.getString("ORIGINAL_TEXT"));
				request.setTranslatedText(rs.getString("TRANSLATED_TEXT"));
				
				results.add(request);
			}
		} catch (SQLException exception) {
			StringBuffer buffer = new StringBuffer();
			buffer.append("An error has occurred when retrieving all requests.");
			System.err.println(buffer.toString() + " - " + exception.getMessage());			
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException exception) {}
		}
		return results;
	}
}
