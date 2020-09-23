package com.inova.etfb.test.data_loaders;

import com.inova.dao.entities.*;
import com.inova.dao.repositories.EnforcementDefaulterEmployerGenerateRepository;
import com.inova.dao.repositories.EnforcementDefaulterEmployerRepository;
import com.inova.dao.repositories.MemberAccountNomineeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Component
public class VisitScheduleViewDefaulterControllerTestDataLoader {
	@Autowired
	EnforcementDefaulterEmployerRepository enforcementDefaulterEmployerRepository;
	@Autowired
	EnforcementDefaulterEmployerGenerateRepository enforcementDefaulterEmployerGenerateRepository;
	@Autowired
	TxnCommonDataLoader txnCommonDataLoader;
	@Autowired
	MstDataLoader mstDataLoader;
	
	public EnforcementDefaulterEmployer insertEnforcementDefaulterEmployer() {
		EnforcementDefaulterEmployer enforcementDefaulterEmployer = getExistingMemberAccountNominee();
		if (enforcementDefaulterEmployer != null) {
			return enforcementDefaulterEmployer;
		} else {
			EnforcementDefaulterEmployerGenerate enforcementDefaulterEmployerGenerate = new EnforcementDefaulterEmployerGenerate();
			enforcementDefaulterEmployerGenerate.setId(1L);
			enforcementDefaulterEmployerGenerate.setRefNo(1L);
			enforcementDefaulterEmployerGenerate.setEndYear(2020);
			enforcementDefaulterEmployerGenerate.setEndMonth(7);
			enforcementDefaulterEmployerGenerate.setStartMonth(7);
			enforcementDefaulterEmployerGenerate.setStartYear(2019);
			enforcementDefaulterEmployerGenerate.setSignificantDueAmount(new BigDecimal(3000));
			enforcementDefaulterEmployerGenerate.setDefaultMonthsPeriod(3);
			enforcementDefaulterEmployerGenerate.setCreatedAt(new Date());

			enforcementDefaulterEmployerGenerate = enforcementDefaulterEmployerGenerateRepository.save(enforcementDefaulterEmployerGenerate);

			enforcementDefaulterEmployer = new EnforcementDefaulterEmployer();
			enforcementDefaulterEmployer.setEnforcementDefaulterEmployerGenerateId(enforcementDefaulterEmployerGenerate);
			enforcementDefaulterEmployer.setEmployerId(txnCommonDataLoader.insertEmployer());
			enforcementDefaulterEmployer.setMonth(6);
			enforcementDefaulterEmployer.setYear(2020);
			enforcementDefaulterEmployer.setStatusId(mstDataLoader.insertMstEnforcementDefaulterStatus());
			enforcementDefaulterEmployer.setDueAmount(new BigDecimal(1000));
			return enforcementDefaulterEmployerRepository.save(enforcementDefaulterEmployer);
		}

	}
	private EnforcementDefaulterEmployer getExistingMemberAccountNominee() {
		List<EnforcementDefaulterEmployer> enforcementDefaulterEmployers = enforcementDefaulterEmployerRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!enforcementDefaulterEmployers.isEmpty()) {
			return enforcementDefaulterEmployers.get(0);
		} else {
			return null;
		}
	}
	
}
