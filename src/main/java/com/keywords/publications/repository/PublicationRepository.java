package com.keywords.publications.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.keywords.publications.model.PublicationRequest;
/**
 * 
 * @author BrijendraK
 *
 */
public interface PublicationRepository extends JpaRepository<PublicationRequest, String>{

}
