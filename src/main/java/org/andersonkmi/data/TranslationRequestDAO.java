package org.andersonkmi.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
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
		return null;
	}
}
