package com.inova.etfb.test.data_loaders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.inova.dao.entities.EmployerDocumentSystem;
import com.inova.dao.repositories.EmployerDocumentSystemRepository;
import com.inova.dao.repositories.TxnEmployerRepository;


@Component
public class EmployerRemmitanceTestDataLoader {
	
	
	@Autowired
	private EmployerDocumentSystemRepository employerDocumentSystemRepository;
	
	@Autowired
	private TxnCommonDataLoader txnCommonDataLoader;
	
	@Autowired
	private TxnEmployerRepository txnEmployerRepository;
	
	@Autowired
	private MstDataLoader mstDataLoader;
	
	public EmployerDocumentSystem insertEmployerDocumentSystem() {
		
		EmployerDocumentSystem employerDocumentSystem = getExistingEmployerDocumentSystem();
		
		if(employerDocumentSystem != null) {
			return employerDocumentSystem;
		}
		else {
			employerDocumentSystem = new EmployerDocumentSystem();
			employerDocumentSystem.setCreatedOrganizationId(txnCommonDataLoader.insertOrganization());
			employerDocumentSystem.setCreatedBy(txnCommonDataLoader.insertUser());
			employerDocumentSystem.setDocumentTypeId(mstDataLoader.insertMstDocumentType());
			employerDocumentSystem.setEmployerId(txnCommonDataLoader.insertEmployer());
			employerDocumentSystem.setDocumentUploadedId(txnCommonDataLoader.insertDocumentUpload());
			employerDocumentSystem.setR4Year(2001);
			employerDocumentSystem.setR4Month(4);
			return employerDocumentSystemRepository.save(employerDocumentSystem);
		}
		
	}
	
	private EmployerDocumentSystem getExistingEmployerDocumentSystem() {		
		List<EmployerDocumentSystem> content = this.employerDocumentSystemRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!content.isEmpty()) {
			return content.get(0);
		} else {
			return null;
		}
	
	}

}
