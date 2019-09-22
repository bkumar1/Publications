package com.keywords.publications.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author BrijendraK
 *
 */
@JsonInclude(Include.NON_NULL)
public class PublicationResponse {
	@JsonProperty(required = true)
	private String name = null;
	@JsonProperty(required = true)
	private String message = null;
	@JsonProperty(required = true)
	private String statusCode = null;
	
	private List<PublicationRequest> books =  new ArrayList<PublicationRequest>();

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the statusCode
	 */
	public String getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * @return the books
	 */
	public List<PublicationRequest> getBooks() {
		return books;
	}

	/**
	 * @param books the books to set
	 */
	public void setBooks(List<PublicationRequest> books) {
		this.books = books;
	}
}
