package com.inova.etfb.test.data_loaders;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.inova.dao.entities.DocumentUploaded;
import com.inova.dao.entities.Member1;
import com.inova.dao.entities.MstCountry;
import com.inova.dao.entities.MstDocumentType;
import com.inova.dao.entities.MstMemberCreatedSource;
import com.inova.dao.entities.MstPersonStatus;
import com.inova.dao.entities.MstTitle;
import com.inova.dao.entities.Person;
import com.inova.dao.entities.PersonDocument;
import com.inova.dao.entities.PersonIdentityPassport;
import com.inova.dao.repositories.DocumentUploadedRepository;
import com.inova.dao.repositories.Member1Repository;
import com.inova.dao.repositories.PersonDocumentRepository;
import com.inova.dao.repositories.PersonIdentityPassportRepository;
import com.inova.dao.repositories.PersonRepository;

@Component
public class PersonProfileIdentityPassportControllerTestDataLoader {
	@Autowired
	private PersonIdentityPassportRepository personIdentityPassportRepository;
	@Autowired
	PersonRepository personRepository;
	@Autowired
	PersonDocumentRepository personDocumentRepository;
	@Autowired
	DocumentUploadedRepository documentUploadedRepository;
	@Autowired
	Member1Repository member1Repository;
	
	public PersonIdentityPassport insertPersonIdentityPassport() {
		PersonIdentityPassport entity = getExistingPersonIdentityPassport();

		if (entity != null) {
			return entity;
		} else {
			entity = new PersonIdentityPassport();
			Person person = insertPerson();
			entity.setPersonId(person);
			entity.setPassportNo("TEST8888PP");
			MstCountry mstCountry = new MstCountry();
			mstCountry.setId(1l);
			entity.setCountryId(mstCountry);
			entity.setCreatedAt(new Date());
			entity.setUpdatedAt(new Date());
			return personIdentityPassportRepository.save(entity);
		}
	}
	private PersonIdentityPassport getExistingPersonIdentityPassport() {
		List<PersonIdentityPassport> list = personIdentityPassportRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}
	public Person insertPerson() {
		Person person = getExistingPerson();
		if (person != null) {
			return person;
		} else {
			person = new Person();
			person.setRefNo(123);
			MstPersonStatus status = new MstPersonStatus();
			status.setId(1l);
			person.setStatusId(status);
			person.setStatusAt(new Date());
			MstTitle title = new MstTitle();
			title.setId(1l);
			person.setTitleId(title);
			person.setFullName("Sample Full Name");
			person.setCreatedAt(new Date());
			person.setUpdatedAt(new Date());
			return personRepository.save(person);
		}
	}

	private Person getExistingPerson() {
		List<Person> persons = personRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!persons.isEmpty()) {
			return persons.get(0);
		} else {
			return null;
		}
	}
	public PersonDocument insertPersonDocument() {
		PersonDocument personDocument = getExistingPersonDocument();
		if (personDocument != null) {
			return personDocument;
		} else {
			personDocument = new PersonDocument();
			personDocument.setPersonId(insertPerson());
			DocumentUploaded documentUploaded = new DocumentUploaded();
			documentUploaded.setId(1l);
			personDocument.setDocumentUploadedId(documentUploaded);
			return personDocumentRepository.save(personDocument);
		}
	}
	private PersonDocument getExistingPersonDocument() {
		List<PersonDocument> list = personDocumentRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}
	
	public DocumentUploaded insertDocumentUploaded() {
		DocumentUploaded documentUploaded = getExistingDocumentUploaded();
		if (documentUploaded != null) {
			return documentUploaded;
		} else {
			documentUploaded = new DocumentUploaded();
			MstDocumentType mstDocumentType = new MstDocumentType();
			mstDocumentType.setId(1l);
			documentUploaded.setDocumentTypeId(mstDocumentType);
			documentUploaded.setName("Test Document by Pamitha");
			return documentUploadedRepository.save(documentUploaded);
		}
	}
	private DocumentUploaded getExistingDocumentUploaded() {
		List<DocumentUploaded> list = documentUploadedRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}
	
	// create member
	public Member1 insertMember() {
		Member1 member = getExistingMember();
		if (member != null) {
			return member;
		} else {
			member = new Member1();
			member.setPersonId(insertPerson());
			MstMemberCreatedSource mstMemberCreatedSource = new MstMemberCreatedSource();
			mstMemberCreatedSource.setId(1l);
			member.setCreatedSourceId(mstMemberCreatedSource);
			return member1Repository.save(member);
		}
		
	}

	private Member1 getExistingMember() {
		List<Member1> member = member1Repository.findAll(PageRequest.of(0, 1)).getContent();
		if(!member.isEmpty()) {
			return member.get(0);
		} else {
			return null;
		}
	}
}
