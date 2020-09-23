package com.inova.etfb.test.data_loaders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.inova.dao.entities.EmployerDirector;
import com.inova.dao.repositories.EmployerDirectorRepository;

@Component
public class PersonProfileDirectorOwnerPartnerDetailsTestDataLoader {

	@Autowired
	private EmployerDirectorRepository employerDirectorRepository;
	@Autowired
	private TxnCommonDataLoader commonDataLoader;
	
	public EmployerDirector insertEmployerDirector() {
		EmployerDirector employerDirector = this.getExistingEmployerDirector();
		if(employerDirector != null) {
			return employerDirector;
		} else {
			employerDirector = new EmployerDirector();
			employerDirector.setEmployerId(commonDataLoader.insertEmployer());
			employerDirector.setPersonId(commonDataLoader.insertPerson());
			employerDirector.setActive(true);
			employerDirector.setMigrated(false);
			
			return this.employerDirectorRepository.save(employerDirector);
		}
	}
	
	private EmployerDirector getExistingEmployerDirector() {
		List<EmployerDirector> content = this.employerDirectorRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!content.isEmpty()) {
			return content.get(0);
		} else {
			return null;
		}
	}
	
}
