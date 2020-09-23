package com.inova.etfb.test.data_loaders;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.inova.dao.entities.AwarenessProgram;
import com.inova.dao.entities.MstAwarenessProgramStatus;
import com.inova.dao.entities.MstAwarenessProgramType;
import com.inova.dao.repositories.AwarenessProgramRepository;

@Component
public class AwarenessProgramControllerTestDataLoader {
	
	@Autowired
	AwarenessProgramRepository awarenessProgramRepository;
	@Autowired
	PersonAddressControllerTestDataLoader personAddressControllerTestDataLoader;
	@Autowired
	TxnCommonDataLoader txnCommonDataLoader;
	@Autowired
	MstDataLoader mstDataLoader;
	
	//Awareness Program
	public AwarenessProgram insertAwarenessProgram() {
		AwarenessProgram awarenessProgram = getExistingAwarenessProgram();
		if (awarenessProgram != null) {
			return awarenessProgram;
		} else {
			awarenessProgram = new AwarenessProgram();
			awarenessProgram.setRefNo(123);
			awarenessProgram.setName("Awareness Program Name");
			awarenessProgram.setAwarenessProgramTypeId(new MstAwarenessProgramType(3l));
			awarenessProgram.setCreatedAt(new Date());
			awarenessProgram.setUpdatedAt(new Date());
			awarenessProgram.setAddressId(personAddressControllerTestDataLoader.insertAddress());
			awarenessProgram.setEtfbZoneId(mstDataLoader.insertEtfbZone());
			awarenessProgram.setCreatedOrganizationId(txnCommonDataLoader.insertOrganization());
			awarenessProgram.setStatusId(new MstAwarenessProgramStatus(1l));
			awarenessProgram.setStatusAt(new Date());
			return awarenessProgramRepository.save(awarenessProgram);
		}
		
	}
	private AwarenessProgram getExistingAwarenessProgram() {
		List<AwarenessProgram> awarenessProgram = awarenessProgramRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!awarenessProgram.isEmpty()) {
			return awarenessProgram.get(0);
		} else {
			return null;
		}
	}

}
