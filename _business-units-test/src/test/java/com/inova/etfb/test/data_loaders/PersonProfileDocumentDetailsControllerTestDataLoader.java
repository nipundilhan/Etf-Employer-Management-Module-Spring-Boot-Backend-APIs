package com.inova.etfb.test.data_loaders;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.inova.dao.entities.DmuOutbound;
import com.inova.dao.entities.DmuOutboundDocumentModule;
import com.inova.dao.entities.DocumentUploaded;
import com.inova.dao.entities.MstDmuDeliveryType;
import com.inova.dao.entities.MstDmuOutboundStatus;
import com.inova.dao.entities.MstDmuOwnerDivisionType;
import com.inova.dao.entities.MstLanguage;
import com.inova.dao.entities.MstUserCategory;
import com.inova.dao.entities.PersonDocument;
import com.inova.dao.entities.User;
import com.inova.dao.repositories.DmuOutboundDocumentModuleRepository;
import com.inova.dao.repositories.DmuOutboundRepository;
import com.inova.dao.repositories.DocumentUploadedRepository;
import com.inova.dao.repositories.PersonDocumentRepository;
import com.inova.dao.repositories.UserRepository;

@Component
public class PersonProfileDocumentDetailsControllerTestDataLoader {

	@Autowired
	private DmuOutboundRepository dmuOutboundRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PersonDocumentRepository personDocumentRepository;
	@Autowired
	private DocumentUploadedRepository documentUploadedRepository;
	@Autowired
	private DmuOutboundDocumentModuleRepository dmuOutboundDocumentModuleRepository; 
	@Autowired
	private MstDataLoader mstDataLoader;
	@Autowired
	private TxnCommonDataLoader commonDataLoader;
	
	public DmuOutboundDocumentModule insertDmuOutboundDocumentModule() {
		DmuOutboundDocumentModule dmuOutboundDocumentModule = this.getExistingDmuOutboundDocumentModule();
		if(dmuOutboundDocumentModule != null) {
			return dmuOutboundDocumentModule;
		} else {
			dmuOutboundDocumentModule = new DmuOutboundDocumentModule();
			dmuOutboundDocumentModule.setDmuOutboundId(insertDmuOutbound());
			dmuOutboundDocumentModule.setCreatedAt(new Date());
			dmuOutboundDocumentModule.setPersonDocumentId(insertPersonDocument());
			
			return dmuOutboundDocumentModule;
		}
	}
	
	private DmuOutboundDocumentModule getExistingDmuOutboundDocumentModule() {
		List<DmuOutboundDocumentModule> content = this.dmuOutboundDocumentModuleRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!content.isEmpty()) {
			return content.get(0);
		} else {
			return null;
		}
	}
	
	public DmuOutbound insertDmuOutbound() {
		DmuOutbound dmuOutbound = getExistingDmuOutbound();
		if(dmuOutbound != null) {
			return dmuOutbound;
		} else {
			dmuOutbound = new DmuOutbound();
			dmuOutbound.setRefNo(10101010);
			dmuOutbound.setDocumentTypeId(mstDataLoader.insertMstDocumentType());
			MstDmuOwnerDivisionType mstDmuOwnerDivisionType = new MstDmuOwnerDivisionType();
			mstDmuOwnerDivisionType.setId(1L);
			dmuOutbound.setOwnerDivisionTypeId(mstDmuOwnerDivisionType);
			MstDmuDeliveryType mstDmuDeliveryType = new MstDmuDeliveryType();
			mstDmuDeliveryType.setId(1L);
			dmuOutbound.setDeliveryTypeId(mstDmuDeliveryType);
			MstLanguage mstLanguage = new MstLanguage();
			mstLanguage.setId(1L);
			dmuOutbound.setLanguageId(mstLanguage);
			dmuOutbound.setSenderUserId(this.insertUser());
			dmuOutbound.setPrintRequiredAtDmu(true);
			dmuOutbound.setPrintedAtDmu(true);
			MstDmuOutboundStatus mstDmuOutboundStatus = new MstDmuOutboundStatus();
			mstDmuOutboundStatus.setId(1L);
			dmuOutbound.setStatusId(mstDmuOutboundStatus);
			dmuOutbound.setStatusAt(new Date());
			dmuOutbound.setCreatedAt(new Date());
			dmuOutbound.setUpdatedAt(new Date());
			
			return dmuOutboundRepository.save(dmuOutbound);
		}
	}
	
	private DmuOutbound getExistingDmuOutbound() {
		List<DmuOutbound> content = this.dmuOutboundRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!content.isEmpty()) {
			return content.get(0);
		} else {
			return null;
		}
	}
	
	public User insertUser() {
		User user = getExistingUser();
		if(user != null) {
			return user;
		} else {
			user = new User();
			MstUserCategory mstUserCategory = new MstUserCategory();
			mstUserCategory.setId(1L);
			user.setCategoryId(mstUserCategory);
			user.setUsername("test username");
			user.setPassword("test password");
			user.setDisplayName("test display name");
			user.setActive(true);
			user.setCreatedAt(new Date());
			user.setInvalidLoginCount(1);
			user.setMigrated(true);
			
			return this.userRepository.save(user);
		}
	}
	
	private User getExistingUser() {
		List<User> user = this.userRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!user.isEmpty()) {
			return user.get(0);
		} else {
			return null;
		}
	}
	
	public PersonDocument insertPersonDocument() {
		PersonDocument personDocument = getExistingPersonDocument();
		if(personDocument != null) {
			return personDocument;
		} else {
			personDocument = new PersonDocument();
			personDocument.setPersonId(commonDataLoader.insertPerson());
			personDocument.setDocumentUploadedId(insertDocumentUploaded());
			
			return this.personDocumentRepository.save(personDocument);
		}
	}
	
	private PersonDocument getExistingPersonDocument() {
		List<PersonDocument> personDocument = this.personDocumentRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!personDocument.isEmpty()) {
			return personDocument.get(0);
		} else {
			return null;
		}
	}
	
	public DocumentUploaded insertDocumentUploaded() {
		DocumentUploaded documentUploaded = getExistingDocumentUploaded();
		if(documentUploaded != null) {
			return documentUploaded;
		} else {
			documentUploaded = new DocumentUploaded();
			documentUploaded.setDocumentTypeId(mstDataLoader.insertMstDocumentType());
			documentUploaded.setName("test name");
			documentUploaded.setDmsRef("test dms ref");
			documentUploaded.setCreatedAt(new Date());
			documentUploaded.setFinalDoc(true);
			
			return this.documentUploadedRepository.save(documentUploaded);
		}
	}
	
	private DocumentUploaded getExistingDocumentUploaded() {
		List<DocumentUploaded> documentUploaded = this.documentUploadedRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!documentUploaded.isEmpty()) {
			return documentUploaded.get(0);
		} else {
			return null;
		}
	}
	
}
