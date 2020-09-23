package com.inova.etfb.test.data_loaders;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inova.dao.entities.EmployerInterim;
import com.inova.dao.entities.MstEmployerIndustryType;
import com.inova.dao.entities.MstEmployerInterimReferenceTable;
import com.inova.dao.entities.MstEmployerNatureBusiness;
import com.inova.dao.entities.MstEmployerOrganizationType;
import com.inova.dao.entities.MstEmployerStatus;
import com.inova.dao.entities.MstEmployerType;
import com.inova.dao.repositories.EmployerInterimRepository;

@Component
public class ViewEmployerNotFoundControllerTestDataLoader {
	@Autowired
	EmployerInterimRepository employerInterimRepository;
	@Autowired
	TxnCommonDataLoader txnCommonDataLoader;
	@Autowired
	MstDataLoader mstDataLoader;
	
	
	public EmployerInterim insertEmployerInterim() {
		MstEmployerNatureBusiness natureBusinessSaved = mstDataLoader.insertMstEmployerNatureBusiness();
		MstEmployerIndustryType industryTypeSaved = mstDataLoader.insertMstEmployerIndustryType(1);
		
		MstEmployerOrganizationType organizationType = new MstEmployerOrganizationType();
		organizationType.setId(1l);

		MstEmployerInterimReferenceTable referenceTable = new MstEmployerInterimReferenceTable();
		referenceTable.setId(1l);
		
		MstEmployerType empType = new MstEmployerType();
		empType.setId(1l);

		MstEmployerStatus empStatus = new MstEmployerStatus();
		empStatus.setId(1l);
		
		EmployerInterim ei = new EmployerInterim();
		ei.setName("test employer interim name");
		ei.setNatureOfBusinessId(natureBusinessSaved);
		ei.setEmployerOrganizationTypeId(organizationType);
		ei.setIndustryTypeId(industryTypeSaved);
		ei.setReferenceTableId(referenceTable);
		ei.setCreatedAt(new Date());
		ei.setUpdatedAt(new Date());
		ei.setEmployerTypeId(empType);
		ei.setEmployerStatusId(empStatus);
		return employerInterimRepository.save(ei);
	}
}
