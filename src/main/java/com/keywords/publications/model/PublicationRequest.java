package com.keywords.publications.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author BrijendraK
 *
 */
@JsonInclude(Include.NON_NULL)
public class PublicationRequest {

	@JsonProperty(required = true)
	private String name = null;
	@JsonProperty(required = true)
	private String title = null;
	@JsonProperty(required = true)
	private String year = null;
	@JsonProperty(required = true)
	private String hero = null;

	enum Genre {
		Drama, Novel, Detective;
	}

	@JsonProperty(required = true)
	private Genre genre;

	enum Type {
		Printed,Online;
	}

	@JsonProperty(required = true)
	private Type type;

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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * @return the hero
	 */
	public String getHero() {
		return hero;
	}

	/**
	 * @param hero the hero to set
	 */
	public void setHero(String hero) {
		this.hero = hero;
	}

	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Type type) {
		this.type = type;
	}

	/**
	 * @return the genre
	 */
	public Genre getGenre() {
		return genre;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(Genre genre) {
		this.genre = genre;
	}

}
