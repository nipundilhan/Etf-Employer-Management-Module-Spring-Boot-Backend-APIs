package com.inova.etfb.test.data_loaders;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.inova.dao.entities.LegalCase;
import com.inova.dao.entities.MstLegalCaseCategory;
import com.inova.dao.entities.MstLegalCasePlaintiffRespondentType;
import com.inova.dao.entities.MstLegalCaseSourceType;
import com.inova.dao.entities.MstLegalCaseStage;
import com.inova.dao.entities.MstLegalCaseStatus;
import com.inova.dao.repositories.LegalCaseRepository;

@Component
public class EmployerLegalCourtControllerTestDataLoader {
	@Autowired
	LegalCaseRepository legalCaseRepository;
	@Autowired
	TxnCommonDataLoader txnCommonDataLoader;
	@Autowired
	MstDataLoader mstDataLoader;
	
	public LegalCase insertLegalCase() {
		LegalCase legalCase = getExistingLegalCase();
		if (legalCase != null) {
			return legalCase;
		} else {
			legalCase = new LegalCase();
			legalCase.setRefNo(123);
			legalCase.setStatusId(new MstLegalCaseStatus(1l));
			legalCase.setCaseStageId(new MstLegalCaseStage(1l));
			legalCase.setCaseCategoryId(new MstLegalCaseCategory(1l));
			legalCase.setSourceTypeId(new MstLegalCaseSourceType(1l));
			legalCase.setCreatedAt(new Date());
			legalCase.setPlaintffTypeId(new MstLegalCasePlaintiffRespondentType(1l));
			legalCase.setRespondentTypeId(new MstLegalCasePlaintiffRespondentType(1l));
			legalCase.setOwnerOrganizationId(txnCommonDataLoader.insertOrganization());
			return legalCaseRepository.save(legalCase);
		}
		
	}
	private LegalCase getExistingLegalCase() {
		List<LegalCase> legalCases = legalCaseRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!legalCases.isEmpty()) {
			return legalCases.get(0);
		} else {
			return null;
		}
	}
	
}
