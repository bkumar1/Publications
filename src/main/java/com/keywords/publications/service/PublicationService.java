package com.keywords.publications.service;

import org.springframework.data.jpa.repository.Query;

import com.keywords.publications.exception.PublicationException;
import com.keywords.publications.model.PublicationRequest;
import com.keywords.publications.model.PublicationResponse;

/**
 * @author BrijendraK
 *
 */
public interface PublicationService {

	public PublicationResponse createPublication(PublicationRequest publicationRequest) throws PublicationException;
	public PublicationResponse deletePublication(PublicationRequest publicationRequest) throws PublicationException;
	public PublicationResponse updatePublication(PublicationRequest publicationRequest) throws PublicationException;
	@Query("SELECT P.titile FROM PublicationRequest P  WHERE p.name= (:name) and p.genure=(:genure)")
	public PublicationResponse getNovels(String name,String genure) throws PublicationException;
	@Query("SELECT P.titile FROM PublicationRequest P  WHERE p.name= (:name) and p.hero=(:hero)")
	public PublicationResponse getComics(String name,String hero) throws PublicationException;

}
