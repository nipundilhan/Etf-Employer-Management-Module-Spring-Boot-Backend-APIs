package com.inova.etfb.test.data_loaders;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.inova.dao.entities.DmuInbound;
import com.inova.dao.entities.DmuInboundBatch;
import com.inova.dao.entities.MstDmuDeliveryType;
import com.inova.dao.entities.MstDmuInboundStatus;
import com.inova.dao.entities.MstDmuPackingType;
import com.inova.dao.entities.MstPriority;
import com.inova.dao.entities.MstServiceCounterRequirementType;
import com.inova.dao.entities.MstServiceCounterResolutionType;
import com.inova.dao.entities.ServiceCounterRequirementType;
import com.inova.dao.repositories.DmuInboundBatchRepository;
import com.inova.dao.repositories.DmuInboundRepository;
import com.inova.dao.repositories.ServiceCounterRequirementTypeRepository;

@Component
public class CreateMemberPortalAccountControllerTestDataLoader {

	@Autowired
	private DmuInboundRepository dmuInboundRepository;
	@Autowired
	private DmuInboundBatchRepository dmuInboundBatchRepository;
	@Autowired
	private ServiceCounterRequirementTypeRepository serviceCounterRequirementTypeRepository;
	@Autowired
	MstDataLoader mstDataLoader;
	@Autowired
	private TxnCommonDataLoader txnCommonDataLoader;
	
	public DmuInbound insertDmuInbound() {
		DmuInbound dmuInbound = getExistingDmuInbound();
		if(dmuInbound != null) {
			return dmuInbound;
		} else {
			dmuInbound = new DmuInbound();
			dmuInbound.setDmuInboundBatchId(insertDmuInboundBatch());
			dmuInbound.setRefNo(123);
			dmuInbound.setPackingTypeId(new MstDmuPackingType(1L));
			dmuInbound.setDocumentTypeId(mstDataLoader.insertMstDocumentType());
			dmuInbound.setDmuReceivedAt(new Date());
			dmuInbound.setCreatedAt(new Date());
			dmuInbound.setUpdatedAt(new Date());
			dmuInbound.setCreatedOrganizationId(txnCommonDataLoader.insertOrganization());
			dmuInbound.setNeedStoreRecordRoom(true);
			dmuInbound.setDmuOutboundCreated(false);
			dmuInbound.setStatusId(new MstDmuInboundStatus(1L));
			dmuInbound.setPaperCount(0);
			
			return dmuInbound;
		}
	}
	
	private DmuInbound getExistingDmuInbound() {
		List<DmuInbound> content = this.dmuInboundRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!content.isEmpty()) {
			return content.get(0);
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
			serviceCounterRequirementType.setServiceCounterId(txnCommonDataLoader.insertServiceCounter());
			serviceCounterRequirementType.setRequirementTypeId(new MstServiceCounterRequirementType(1L));
			serviceCounterRequirementType.setPriorityId(new MstPriority(1L));
			serviceCounterRequirementType.setResolutionTypeId(new MstServiceCounterResolutionType(1L));
			
			return serviceCounterRequirementType;
		}
	}
	
	private ServiceCounterRequirementType getExistingServiceCounterRequirementType() {
		List<ServiceCounterRequirementType> content = this.serviceCounterRequirementTypeRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!content.isEmpty()) {
			return content.get(0);
		} else {
			return null;
		}
	}
	
	public DmuInboundBatch insertDmuInboundBatch() {
		DmuInboundBatch inboundBatch = getExistingDmuInboundBatch();
		if(inboundBatch != null) {
			return inboundBatch;
		} else {
			inboundBatch = new DmuInboundBatch();
			inboundBatch.setRefNo(123);
			inboundBatch.setDeliveryTypeId(new MstDmuDeliveryType(1L));
			inboundBatch.setDmuReceivedAt(new Date());
			inboundBatch.setCreatedOrganizationId(txnCommonDataLoader.insertOrganization());
			inboundBatch.setLetterCount(1);
			
			return inboundBatch;
		}
	}
	
	private DmuInboundBatch getExistingDmuInboundBatch() {
		List<DmuInboundBatch> content = this.dmuInboundBatchRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!content.isEmpty()) {
			return content.get(0);
		} else {
			return null;
		}	 
	}
	
}
