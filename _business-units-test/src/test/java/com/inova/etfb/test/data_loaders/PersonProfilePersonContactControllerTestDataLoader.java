package com.inova.etfb.test.data_loaders;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.inova.dao.entities.DmuInbound;
import com.inova.dao.entities.DmuInboundBatch;
import com.inova.dao.entities.DocumentUploaded;
import com.inova.dao.entities.MstPriority;
import com.inova.dao.entities.PersonDocument;
import com.inova.dao.entities.ServiceCounter;
import com.inova.dao.entities.ServiceCounterRequirementType;
import com.inova.dao.repositories.DmuInboundBatchRepository;
import com.inova.dao.repositories.DmuInboundRepository;
import com.inova.dao.repositories.DocumentUploadedRepository;
import com.inova.dao.repositories.PersonDocumentRepository;
import com.inova.dao.repositories.ServiceCounterRepository;
import com.inova.dao.repositories.ServiceCounterRequirementTypeRepository;

@Component
public class PersonProfilePersonContactControllerTestDataLoader {

	@Autowired
	private PersonDocumentRepository personDocumentRepository;
	@Autowired
	private DocumentUploadedRepository documentUploadedRepository;
	@Autowired
	DmuInboundBatchRepository dmuInboundBatchRepository;
	@Autowired
	DmuInboundRepository dmuInboundRepository;
	@Autowired
	ServiceCounterRequirementTypeRepository serviceCounterRequirementTypeRepository;
	@Autowired
	ServiceCounterRepository serviceCounterRepository;
	
	@Autowired
	TxnCommonDataLoader txnCommonDataLoader;
	@Autowired
	MetaDataLoader metaDataLoader;
	@Autowired
	private MstDataLoader mstDataLoader;
	@Autowired
	private TxnCommonDataLoader commonDataLoader;

	public PersonDocument insertPersonDocument() {
		PersonDocument personDocument = getExistingPersonDocument();
		if (personDocument != null) {
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
		if (!personDocument.isEmpty()) {
			return personDocument.get(0);
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
			documentUploaded.setDocumentTypeId(mstDataLoader.insertMstDocumentType());
			documentUploaded.setName("test name");
			documentUploaded.setDmsRef("test dms ref");
			documentUploaded.setCreatedAt(new Date());
			documentUploaded.setFinalDoc(true);

			return this.documentUploadedRepository.save(documentUploaded);
		}
	}

	private DocumentUploaded getExistingDocumentUploaded() {
		List<DocumentUploaded> documentUploaded = this.documentUploadedRepository.findAll(PageRequest.of(0, 1))
				.getContent();
		if (!documentUploaded.isEmpty()) {
			return documentUploaded.get(0);
		} else {
			return null;
		}
	}
	
	public DmuInbound insertDmuInbound() {
		DmuInbound dmuInbound = getExistingDmuInbound();
		if (dmuInbound != null) {
			return dmuInbound;
		} else {
			dmuInbound = new DmuInbound();
			dmuInbound.setRefNo(1l);
			dmuInbound.setDmuInboundBatchId(insertDmuInboundBatch());
			dmuInbound.setPackingTypeId(mstDataLoader.insertMstDmuPackingType());
			dmuInbound.setDocumentTypeId(mstDataLoader.insertMstDocumentType());
			dmuInbound.setDmuReceivedAt(new Date());
			dmuInbound.setCreatedAt(new Date());
			dmuInbound.setCreatedOrganizationId(txnCommonDataLoader.insertOrganization());
			dmuInbound.setUpdatedAt(new Date());
			dmuInbound.setStatusId(mstDataLoader.insertMstDmuInboundStatus());
			return dmuInboundRepository.save(dmuInbound);
		}
	}

	private DmuInbound getExistingDmuInbound() {
		List<DmuInbound> dmuInbounds = dmuInboundRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!dmuInbounds.isEmpty()) {
			return dmuInbounds.get(0);
		} else {
			return null;
		}
	}
	
	private DmuInboundBatch insertDmuInboundBatch() {
		DmuInboundBatch dmuInboundBatch = getExistingDmuInboundBatch();
		if (dmuInboundBatch != null) {
			return dmuInboundBatch;
		} else {
			dmuInboundBatch = new DmuInboundBatch();
			dmuInboundBatch.setRefNo(1l);
			dmuInboundBatch.setDeliveryTypeId(metaDataLoader.getMstDmuDeliveryType());
			dmuInboundBatch.setDmuReceivedAt(new Date());
			dmuInboundBatch.setCreatedAt(new Date());
			dmuInboundBatch.setCreatedOrganizationId(txnCommonDataLoader.insertOrganization());
			dmuInboundBatch.setUpdatedAt(new Date());
			return dmuInboundBatchRepository.save(dmuInboundBatch);
		}
	}

	private DmuInboundBatch getExistingDmuInboundBatch() {
		List<DmuInboundBatch> dmuInboundBatches = dmuInboundBatchRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!dmuInboundBatches.isEmpty()) {
			return dmuInboundBatches.get(0);
		} else {
			return null;
		}
	}
	
	public ServiceCounterRequirementType insertServiceCounterRequirementType() {
		ServiceCounterRequirementType serviceCounterRequirementType = getExistingServiceCounterRequirementType();
		if(serviceCounterRequirementType != null) {
			return serviceCounterRequirementType;
		} else {
			serviceCounterRequirementType = new ServiceCounterRequirementType();
			serviceCounterRequirementType.setServiceCounterId(insertServiceCounter());
			serviceCounterRequirementType.setRequirementTypeId(mstDataLoader.insertMstServiceCounterRequirementType());
			serviceCounterRequirementType.setPriorityId(mstDataLoader.insertMstPriority());
			serviceCounterRequirementType.setResolutionTypeId(mstDataLoader.insertMstServiceCounterResolutionType());
			serviceCounterRequirementType.setCreatedAt(new Date());
			return this.serviceCounterRequirementTypeRepository.save(serviceCounterRequirementType);
		}
		
	}
	
	private ServiceCounterRequirementType getExistingServiceCounterRequirementType() {
		List<ServiceCounterRequirementType> serviceCounterRequirmentTypes = serviceCounterRequirementTypeRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!serviceCounterRequirmentTypes.isEmpty()) {
			return serviceCounterRequirmentTypes.get(0);
		} else {
			return null;
		}
	}
	
	private ServiceCounter insertServiceCounter() {
		ServiceCounter serviceCounter = getExistingServiceCounter();
		if(serviceCounter != null) {
			return serviceCounter;
		} else {
			serviceCounter = new ServiceCounter();
			serviceCounter.setInquiryTypeId(mstDataLoader.insertMstServiceCounterInquiryType());
			serviceCounter.setRefNo(1L);
			serviceCounter.setStatusId(mstDataLoader.insertMstServiceCounterStatus());
			serviceCounter.setStatusAt(new Date());
			serviceCounter.setCreatedAt(new Date());
			return this.serviceCounterRepository.save(serviceCounter);
		}
		
	}
	
	private ServiceCounter getExistingServiceCounter() {
		List<ServiceCounter> serviceCounters = serviceCounterRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!serviceCounters.isEmpty()) {
			return serviceCounters.get(0);
		} else {
			return null;
		}
	}
}
