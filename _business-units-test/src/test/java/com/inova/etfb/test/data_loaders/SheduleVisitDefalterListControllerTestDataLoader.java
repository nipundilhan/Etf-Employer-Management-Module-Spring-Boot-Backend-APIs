package com.inova.etfb.test.data_loaders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.inova.dao.entities.EnforcementDefaulterEmployer;
import com.inova.dao.entities.EnforcementDefaulterEmployerGenerate;
import com.inova.dao.repositories.EnforcementDefaulterEmployerGenerateRepository;
import com.inova.dao.repositories.EnforcementDefaulterEmployerRepository;

@Component
public class SheduleVisitDefalterListControllerTestDataLoader {
	@Autowired
	EnforcementDefaulterEmployerRepository enforcementDefaulterEmployerRepository;
	@Autowired
	EnforcementDefaulterEmployerGenerateRepository enforcementDefaulterEmployerGenerateRepository;
	@Autowired
	MstDataLoader mstDataLoader;	
	
	public EnforcementDefaulterEmployerGenerate insertEnforcementDefaulterEmployerGenerate() {
		EnforcementDefaulterEmployerGenerate enforcementDefaulterEmployerGenerate = getExistingEnforcementDefaulterEmployerGenerate();
		if (enforcementDefaulterEmployerGenerate != null) {
			return enforcementDefaulterEmployerGenerate;
		} else {
			enforcementDefaulterEmployerGenerate = new EnforcementDefaulterEmployerGenerate();
//			person.setRefNo(123);
//			MstPersonStatus status = new MstPersonStatus();
//			status.setId(1l);
//			person.setStatusId(status);
//			person.setStatusAt(new Date());
//			person.setGender('M');
//			person.setTitleId(this.mstDataLoader.insertMstTitle(1L));
//			person.setFullName("Sample Full Name");
//			person.setCreatedAt(new Date());
//			person.setUpdatedAt(new Date());
			return enforcementDefaulterEmployerGenerateRepository.save(enforcementDefaulterEmployerGenerate);
		}
	}

	private EnforcementDefaulterEmployerGenerate getExistingEnforcementDefaulterEmployerGenerate() {
		List<EnforcementDefaulterEmployerGenerate> enforcementDefaulterEmployerGenerate = enforcementDefaulterEmployerGenerateRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!enforcementDefaulterEmployerGenerate.isEmpty()) {
			return enforcementDefaulterEmployerGenerate.get(0);
		} else {
			return null;
		}
	}
	
	public EnforcementDefaulterEmployer insertEnforcementDefaulterEmployer() {
		EnforcementDefaulterEmployer enforcementDefaulterEmployer = getExistingEnforcementDefaulterEmployer();
		if (enforcementDefaulterEmployer != null) {
			return enforcementDefaulterEmployer;
		} else {
			enforcementDefaulterEmployer = new EnforcementDefaulterEmployer();
//			person.setRefNo(123);
//			MstPersonStatus status = new MstPersonStatus();
//			status.setId(1l);
//			person.setStatusId(status);
//			person.setStatusAt(new Date());
//			person.setGender('M');
//			person.setTitleId(this.mstDataLoader.insertMstTitle(1L));
//			person.setFullName("Sample Full Name");
//			person.setCreatedAt(new Date());
//			person.setUpdatedAt(new Date());
			return this.enforcementDefaulterEmployerRepository.save(enforcementDefaulterEmployer);
		}
	}

	private EnforcementDefaulterEmployer getExistingEnforcementDefaulterEmployer() {
		List<EnforcementDefaulterEmployer> enforcementDefaulterEmployer = this.enforcementDefaulterEmployerRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!enforcementDefaulterEmployer.isEmpty()) {
			return enforcementDefaulterEmployer.get(0);
		} else {
			return null;
		}
	}
	
	
}
