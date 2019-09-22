package com.keywords.publications.exception;

/**
 * @author BrijendraK
 *
 */
public class PublicationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * @param exception
	 */
	public PublicationException(String exception) {
		super(exception);
	}

}