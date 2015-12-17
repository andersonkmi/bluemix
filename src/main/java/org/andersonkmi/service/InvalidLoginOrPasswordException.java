package org.andersonkmi.service;

public class InvalidLoginOrPasswordException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2128181022171342819L;

	public InvalidLoginOrPasswordException() {
		// TODO Auto-generated constructor stub
	}

	public InvalidLoginOrPasswordException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidLoginOrPasswordException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidLoginOrPasswordException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidLoginOrPasswordException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
