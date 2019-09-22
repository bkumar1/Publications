package com.keywords.publications.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.keywords.publications.constants.PublicationConstants.*;
import com.keywords.publications.exception.PublicationException;
import com.keywords.publications.model.PublicationRequest;
import com.keywords.publications.model.PublicationResponse;
import com.keywords.publications.service.PublicationService;

/**
 * 
 * @author BrijendraK
 */

@RestController
@RequestMapping(PUBLICATIONS_BASE_URI)
public class PublicationController {
	private static final Logger log = LoggerFactory.getLogger(PublicationController.class);
	@Autowired
	private PublicationService publicationService;
	private PublicationResponse publicationResponse = null;

	/**
	 * 
	 * @param publicationRequest
	 * @return
	 * @throws PublicationException
	 */
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PublicationResponse> createpublication(@Valid @RequestBody PublicationRequest publicationRequest)
			throws PublicationException {
		log.info("createpublication call Satrt");

		try {
			publicationResponse = publicationService.createPublication(publicationRequest);
		} catch (Exception ex) {
			throw new PublicationException(ex.getMessage());
		}

		log.info("createpublication call end");
		return ResponseEntity.ok().body(publicationResponse);
	}

	/**
	 * 
	 * @param publicationRequest
	 * @return
	 * @throws PublicationException
	 */
	@RequestMapping(method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PublicationResponse> deletePublication(@Valid @RequestBody PublicationRequest publicationRequest)
			throws PublicationException {
		log.info("deletePublication call start");

		try {
			publicationResponse = publicationService.deletePublication(publicationRequest);
		} catch (Exception ex) {
			throw new PublicationException(ex.getMessage());
		}

		log.info("deletePublication call end");
		return ResponseEntity.ok().body(publicationResponse);

	}
	
	/**
	 * 
	 * @param publicationRequest
	 * @return
	 * @throws PublicationException
	 */

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PublicationResponse> updatePublication(@Valid @RequestBody PublicationRequest publicationRequest)
			throws PublicationException {
		log.info("updatePublication call start");

		try {
			publicationResponse = publicationService.updatePublication(publicationRequest);
		} catch (Exception ex) {
			throw new PublicationException(ex.getMessage());
		}

		log.info("updatePublication call end");
		return ResponseEntity.ok().body(publicationResponse);

	}
	
	/**
	 * 
	 * @param name
	 * @param year
	 * @return
	 * @throws PublicationException
	 */
	@RequestMapping(name=VIEW_NOVELS_URI,method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PublicationResponse> getNovels(@PathVariable("name") String name,
			@PathVariable("genure") String genure)
			throws PublicationException {
		log.info("getNovels call start");

		try {
			publicationResponse = publicationService.getNovels(name,genure);
		} catch (Exception ex) {
			throw new PublicationException(ex.getMessage());
		}

		log.info("getNovels call end");
		return ResponseEntity.ok().body(publicationResponse);

	}
	
	@RequestMapping(name=VIEW_COMICS_URI,method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PublicationResponse> getComics(@PathVariable("name") String name,
			@PathVariable("hero") String hero)
			throws PublicationException {
		log.info("getComics call start");

		try {
			publicationResponse = publicationService.getComics(name,hero);
		} catch (Exception ex) {
			throw new PublicationException(ex.getMessage());
		}

		log.info("getComics call end");
		return ResponseEntity.ok().body(publicationResponse);

	}

}