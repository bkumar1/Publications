package com.keywords.publications.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.keywords.publications.exception.PublicationException;
import com.keywords.publications.model.PublicationRequest;
import com.keywords.publications.model.PublicationResponse;
import com.keywords.publications.repository.PublicationRepository;
import com.keywords.publications.service.PublicationService;

/**
 * 
 * @author BrijendraK 
 *
 */
@Service
public class PublicationServiceImpl implements PublicationService {
	private static final Logger log = LoggerFactory.getLogger(PublicationServiceImpl.class);
	@Autowired
	private PublicationRepository repository;
	private PublicationResponse publicationResponse;

	

	@Override
	public PublicationResponse createPublication(PublicationRequest publicationRequest) throws PublicationException {

		log.info("createPublication - DB call Start");

		Optional<PublicationRequest> publication = repository.findById(publicationRequest.getName());

		if (!publication.isPresent()) {
			publicationRequest = repository.save(publicationRequest);
			if (null != publicationRequest) {
				publicationResponse.setName(publicationRequest.getName());
				publicationResponse.setMessage("Publication created successfully");
				publicationResponse.setStatusCode(String.valueOf(HttpStatus.CREATED));
				log.info("Publication created successfully");
			}
		} else {
			throw new PublicationException("publication is not present- not created");
		}

		log.info("createPublication -  DB call End");
		return publicationResponse;
	}

	@Override
	public PublicationResponse deletePublication(PublicationRequest publicationRequest) throws PublicationException {

		log.info("deletePublication DB call Start");

		Optional<PublicationRequest> publication = repository.findById(publicationRequest.getName());
		if (publication.isPresent()) {

			repository.delete(publication.get());
			publicationResponse.setName(publicationRequest.getName());
			publicationResponse.setMessage("Publication deleted successfully");
			publicationResponse.setStatusCode(String.valueOf(HttpStatus.CREATED));
			log.info("Publication deleted successfully");

		} else {
			throw new PublicationException("Publication is not present- not deleted");
		}

		log.info("deletePublication DB call End");
		return publicationResponse;
	}

	
	@Override
	public PublicationResponse updatePublication(PublicationRequest publicationRequest) throws PublicationException {
		log.info("updatePublication DB call Start");

		Optional<PublicationRequest> publication = repository.findById(publicationRequest.getName());

		if (publication.isPresent()) {

			publicationRequest = repository.save(publication.get());
			publicationResponse.setName(publicationRequest.getName());
			publicationResponse.setMessage("Publication updated successfully");
			publicationResponse.setStatusCode(String.valueOf(HttpStatus.CREATED));
			log.info("Publication updated successfully");

		} else {
			throw new PublicationException("Publication is not present- not updated");
		}

		log.info("updatePublication  DB call end");
		return publicationResponse;

	}

	
	@Override
	public PublicationResponse getNovels(String name, String genure) throws PublicationException {
		log.info("getNovels detail DB call start");
		List<PublicationRequest> novelList = repository.findAll();
		if(!novelList.isEmpty())
		{
			publicationResponse.setBooks(novelList);
		}else{
			throw new PublicationException("novels is not present- not get");
		}
		log.info("getNovels detail DB call end");
		return publicationResponse;
	}

	@Override
	public PublicationResponse getComics(String name, String hero) throws PublicationException {
		// TODO Auto-generated method stub
		log.info("getComics detail DB call start");
		List<PublicationRequest> comicsList = repository.findAll();
		if(!comicsList.isEmpty())
		{
			publicationResponse.setBooks(comicsList);
		}else{
			throw new PublicationException("Comics is not present- not get");
		}
		log.info("getComics detail DB call end");
		return publicationResponse;
	}

}
