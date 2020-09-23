package com.inova.etfb.test.data_loaders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.inova.dao.entities.EmployerHistory;
import com.inova.dao.entities.EmployerInterim;
import com.inova.dao.entities.EmployerInterimDirector;
import com.inova.dao.entities.MstEmployerInterimReferenceTable;
import com.inova.dao.repositories.EmployerHistoryRepository;
import com.inova.dao.repositories.EmployerInterimRepository;

@Component
public class ViewEmployerDetailsTestDataLoader {
	
	
	@Autowired
	private EmployerHistoryRepository  employerHistoryRepository;
	@Autowired
	private EmployerInterimRepository  employerInterimRepository;
	@Autowired
	private TxnCommonDataLoader txnCommonDataLoader;
	@Autowired
	private MstDataLoader mstDataLoader;
	
	
	public EmployerHistory insertEmployerHistory() {
		EmployerHistory employerHistory = getExistingEmployerHistory();
		if(employerHistory != null) {
			return employerHistory;
			
		}else{
			employerHistory = new EmployerHistory();
			employerHistory.setEmployerId(txnCommonDataLoader.insertEmployer());
			employerHistory.setEmployerInterimId(insertEmployerInterim());
			return employerHistoryRepository.save(employerHistory);
		}
		
		
	}
	
	public EmployerHistory insertEmployerHistoryDirect() {
		EmployerHistory employerHistory = new EmployerHistory();
		employerHistory.setEmployerId(txnCommonDataLoader.insertEmployer());
		employerHistory.setEmployerInterimId(insertEmployerInterim());
		return employerHistoryRepository.save(employerHistory);		
	}
	
	
	public  EmployerInterim insertEmployerInterim() {
		EmployerInterim employerInterim = getExistingEmployerInterim();
		if(employerInterim != null) {
			return employerInterim;
			
		}else{
			employerInterim = new EmployerInterim();
			employerInterim.setNatureOfBusinessId(mstDataLoader.insertMstEmployerNatureBusiness());
			employerInterim.setName("TestEmployer");
			employerInterim.setEmployerOrganizationTypeId(mstDataLoader.insertMstEmployerOrganizationType());
			employerInterim.setIndustryTypeId(mstDataLoader.insertMstEmployerIndustryType(1));
			MstEmployerInterimReferenceTable referenceTable = new MstEmployerInterimReferenceTable();
			referenceTable.setId(1l);
			employerInterim.setReferenceTableId(referenceTable);
			employerInterim.setEmployerTypeId(mstDataLoader.insertMstEmployerType());
			employerInterim.setEmployerStatusId(mstDataLoader.insertMstEmployerStatus());
			return employerInterimRepository.save(employerInterim);
		
		}
	}
	
	private EmployerHistory getExistingEmployerHistory() {		
		List<EmployerHistory> content = employerHistoryRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!content.isEmpty()) {
			return content.get(0);
		} else {
			return null;
		}		
	}
	
	private EmployerInterim getExistingEmployerInterim() {		
		List<EmployerInterim> content = employerInterimRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!content.isEmpty()) {
			return content.get(0);
		} else {
			return null;
		}		
	}

}
