package com.inova.etfb.test.data_loaders;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.inova.dao.entities.DmuInbound;
import com.inova.dao.entities.DmuInboundBatch;
import com.inova.dao.entities.DmuInboundSenderEmployer;
import com.inova.dao.repositories.DmuInboundBatchRepository;
import com.inova.dao.repositories.DmuInboundRepository;
import com.inova.dao.repositories.DmuInboundSenderEmployerRepository;

@Component
public class EmployerOutBoundDmuControllerTestDataLoader {
	@Autowired
	DmuInboundBatchRepository dmuInboundBatchRepository;
	@Autowired
	DmuInboundRepository dmuInboundRepository;
	@Autowired	
	DmuInboundSenderEmployerRepository dmuInboundSenderEmployerRepository;
	@Autowired
	TxnCommonDataLoader txnCommonDataLoader;
	@Autowired
	MstDataLoader mstDataLoader;
	@Autowired
	MetaDataLoader metaDataLoader;


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
	
	
	public DmuInboundSenderEmployer insertDmuInboundSenderEmployer() {
		DmuInboundSenderEmployer dmuInboundSenderEmployer = getExistingDmuInboundSenderEmployer();
		if(dmuInboundSenderEmployer != null) {
			return dmuInboundSenderEmployer;			
		}else {
			 dmuInboundSenderEmployer = new DmuInboundSenderEmployer();
			 dmuInboundSenderEmployer.setCreatedAt(new Date());
			 dmuInboundSenderEmployer.setDmuInboundId(insertDmuInbound());
			 dmuInboundSenderEmployer.setEmployerId(txnCommonDataLoader.insertEmployer());
			 return dmuInboundSenderEmployerRepository.save(dmuInboundSenderEmployer);
			
		}		
			
	}
	
	public DmuInboundSenderEmployer getExistingDmuInboundSenderEmployer() {
		
		List<DmuInboundSenderEmployer> dmuInboundSenderEmployerList = dmuInboundSenderEmployerRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!dmuInboundSenderEmployerList.isEmpty()) {
			return dmuInboundSenderEmployerList.get(0);
		} else {
			return null;
		}
				
	}
	
	
	public DmuInboundSenderEmployer insertDmuInboundSenderEmployer(DmuInbound dmuInbound ) {
		
		 DmuInboundSenderEmployer dmuInboundSenderEmployer = new DmuInboundSenderEmployer();
		 dmuInboundSenderEmployer.setCreatedAt(new Date());
		 dmuInboundSenderEmployer.setDmuInboundId(dmuInbound);
		 dmuInboundSenderEmployer.setEmployerId(txnCommonDataLoader.insertEmployer());
		 return dmuInboundSenderEmployerRepository.save(dmuInboundSenderEmployer);
		

	}
	
	
	
}
